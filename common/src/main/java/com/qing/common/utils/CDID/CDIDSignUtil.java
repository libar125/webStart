package com.qing.common.utils.CDID;

import com.sun.crypto.provider.SunJCE;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import com.qing.common.utils.CDID.KeyStore;


public class CDIDSignUtil {

    private static final String ALGORITHM = "RSA";
    private static final byte[] VER = EncodesUtil.decodeBase64("Gdp0WDe1XR/BFs9qHai3Gg==");
    private static final KeyFactory keyFactory;
    private AESCryptUtil aesCryptUtil = new AESCryptUtil();

    private static ThreadLocal<Cipher> cipherLocal = new ThreadLocal<>();
    static {
        try {
            keyFactory = KeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("no ALGORITHM for '" + ALGORITHM + "'");
        }
    }


    public byte[] encryptAES(String pubKey, byte[] plaintext) {

        //AES
        SecretKey aesKey = aesCryptUtil.randomKey();
        IvParameterSpec iv = aesCryptUtil.randomIv();
        byte[] enContent = new byte[0];
        try {
            enContent = aesCryptUtil.encrypt(aesKey, iv, plaintext);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            System.out.println("AES加密失败");
        } catch (InvalidKeyException e) {
            System.out.println("AES秘钥不可用");
        }

        try {
            //RSA
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            bout.write(aesKey.getEncoded());
            bout.write(iv.getIV());
            bout.write(VER); //版本信息，对加解密无任何影响
            byte[] enDes = encryptKey(pubKey, bout.toByteArray());

            //parse
            bout.reset();
            bout.write(enDes);
            bout.write(enContent);
            return bout.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("加密发生错误", e);
        }
    }


    public byte[] encryptKey(String pubKey, byte[] content) throws InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException {
        return encrypt(pubKey, content, 0, content.length);
    }

    public byte[] encrypt(String pubKey, byte[] content, int start, int length) throws InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException {
        return doCrypt(pubKey, Cipher.ENCRYPT_MODE, content, start, length);
    }

    private byte[] doCrypt(String key, int mode, byte[] content, int start, int length) throws InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException {
        com.qing.common.utils.CDID.KeyStore store = prepareKeyStore(key, mode);
        Cipher cipher = getCipher(store);
        return cipher.doFinal(content, start, length);
    }

    protected Cipher getCipher(com.qing.common.utils.CDID.KeyStore store) {
        try {
            Cipher cipher = cipherLocal.get();
            if (null == cipher) {
                cipher = Cipher.getInstance(SYSTEM_CIPHER_ALGORITHM, new SunJCE());
                cipherLocal.set(cipher);
            }
            cipher.init(store.getMode(), store.getKey());
            return cipher;
        } catch (Exception e) {
            throw new RuntimeException("没有找到" + SYSTEM_CIPHER_ALGORITHM + "的加密算法", e);
        }
    }

    public static RSAPublicKey getRSAPublicKey(byte[] pubKeyData) throws InvalidKeySpecException {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(pubKeyData);
        return (RSAPublicKey) keyFactory.generatePublic(spec);
    }

    public static RSAPrivateKey getRSAPrivateKey(byte[] priKeyData) throws InvalidKeySpecException {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(priKeyData);
        return (RSAPrivateKey) keyFactory.generatePrivate(spec);
    }


    public boolean verifySign(String pubKey, byte[] sign, byte[] content) throws Exception {
        return verifySign(pubKey, sign, content, 0, content.length);
    }

    public byte[] sign(String priKey, byte[] content) throws Exception {
        return sign(priKey, content, 0, content.length);
    }

    public boolean verifySign(String pubKey, byte[] sign, byte[] content, int start, int length) throws InvalidKeySpecException, SignatureException {
        com.qing.common.utils.CDID.KeyStore store = prepareKeyStore(pubKey, Cipher.PUBLIC_KEY);
        Signature signature = getSignature(store);
        signature.update(content, start, length);
        return signature.verify(sign);
    }


    private static final String SYSTEM_CIPHER_ALGORITHM = "RSA";
    private static final String SYSTEM_SIGNATURE_ALGORITHM = "SHA256withRSA";

    private Map<String, com.qing.common.utils.CDID.KeyStore> priKeyMap = new HashMap<>(512);
    private Map<String, com.qing.common.utils.CDID.KeyStore> pubKeyMap = new HashMap<>(512);


    public byte[] sign(String priKey, byte[] content, int start, int length) throws InvalidKeySpecException, SignatureException {
        KeyStore store = prepareKeyStore(priKey, Cipher.PRIVATE_KEY);
        Signature signature = getSignature(store);
        signature.update(content, start, length);
        return signature.sign();
    }

    protected Signature getSignature(com.qing.common.utils.CDID.KeyStore store) {
        try {
            Signature signature = Signature.getInstance(SYSTEM_SIGNATURE_ALGORITHM);
            if (store.getMode() == Cipher.PRIVATE_KEY) {
                signature.initSign((PrivateKey) store.getKey());
            } else if (store.getMode() == Cipher.PUBLIC_KEY) {
                signature.initVerify((PublicKey) store.getKey());
            }
            return signature;
        } catch (Exception e) {
            throw new RuntimeException("没有找到" + SYSTEM_SIGNATURE_ALGORITHM + "的签名算法", e);
        }
    }

    private com.qing.common.utils.CDID.KeyStore prepareKeyStore(String key, int mode) throws InvalidKeySpecException {
        Map<String, com.qing.common.utils.CDID.KeyStore> storeMap = mode == Cipher.PUBLIC_KEY ? pubKeyMap : priKeyMap;
        com.qing.common.utils.CDID.KeyStore store = storeMap.get(key);

        if (null == store) {
            byte[] keyByte = EncodesUtil.decodeBase64(key);
            Key rsaKey;
            if (mode == Cipher.ENCRYPT_MODE) {
                rsaKey = getRSAPublicKey(keyByte);
            } else {
                rsaKey = getRSAPrivateKey(keyByte);
            }

            store = new KeyStore(rsaKey, mode);
            storeMap.put(key, store);
        }

        return store;
    }

}