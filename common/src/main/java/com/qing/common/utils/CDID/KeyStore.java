package com.qing.common.utils.CDID;

import java.security.Key;

public class KeyStore {

    public KeyStore(Key key, int keyType) {
        this.key = key;
        byte[] src = key.getEncoded();
        base64Src = EncodesUtil.encodeBase64(src);
        this.mode = keyType;
    }

    private String base64Src;

    private Key key;

    private int mode;

    public String getBase64Src() {
        return base64Src;
    }

    public Key getKey() {
        return key;
    }

    public int getMode() {
        return mode;
    }

}
