package com.qing.common.utils.CDID;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

@Data
public class AESCryptUtil {
    public static final int AES_KEY_LENGTH = 128;
    public static final int AES_IV_SIZE = 16;


    private static final String ALGORITHM_KEY = "AES";
    private static final String ALGORITHM_CIPHER = "AES/CBC/PKCS5Padding";

    private static ThreadLocal<Cipher> localCipher = new ThreadLocal<>();

    private KeyGenerator keyGenerator;

    public AESCryptUtil() {
        try {
            keyGenerator = KeyGenerator.getInstance(ALGORITHM_KEY);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有" + ALGORITHM_KEY + "相关的实现");
        }
        keyGenerator.init(AES_KEY_LENGTH, new SecureRandom());
    }


    public byte[] encrypt(Key key, IvParameterSpec iv, byte[] content) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return doCrypt(key, Cipher.ENCRYPT_MODE, iv, content, 0, content.length);
    }

    public byte[] encrypt(Key key, IvParameterSpec iv, byte[] content, int start, int length) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        return doCrypt(key, Cipher.ENCRYPT_MODE, iv, content, start, length);
    }

    public byte[] deCrypt(Key key, IvParameterSpec iv, byte[] content) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        return doCrypt(key, Cipher.DECRYPT_MODE, iv, content, 0, content.length);
    }

    public byte[] deCrypt(Key key, IvParameterSpec iv, byte[] content, int start, int length) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        return doCrypt(key, Cipher.DECRYPT_MODE, iv, content, start, length);
    }

    public SecretKey parseKey(byte[] bytes, int start, int length) {
        return new SecretKeySpec(bytes, start, length, ALGORITHM_KEY);
    }

    public IvParameterSpec parseIv(byte[] bytes, int start, int length) {
        return new IvParameterSpec(bytes, start, length);
    }

    public SecretKey randomKey() {
        return keyGenerator.generateKey();
    }

    public IvParameterSpec randomIv() {
        return parseIv(randomString(AES_IV_SIZE).getBytes(), 0, AES_IV_SIZE);
    }


    public static String randomString(int length) {
        return RandomStringUtils.random(length, "1234567890abcdefABCDEF-/=+_");
    }

    private byte[] doCrypt(Key key, int mode, IvParameterSpec iv, byte[] content, int start, int length) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = getCipher();
        try {
            cipher.init(mode, key, iv);
        } catch (InvalidAlgorithmParameterException e) {
            //正常情况不会出现该异常
            throw new RuntimeException("un expect algorithm-parameter", e);
        }
        return cipher.doFinal(content, start, length);
    }

    private Cipher getCipher() {
        Cipher cipher = localCipher.get();
        if (null == cipher) {
            try {
                cipher = Cipher.getInstance(ALGORITHM_CIPHER);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new RuntimeException("没有找到'" + ALGORITHM_CIPHER + "'的实现", e);
            }
            localCipher.set(cipher);
        }
        return cipher;
    }

}
