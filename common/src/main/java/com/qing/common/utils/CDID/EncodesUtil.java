package com.qing.common.utils.CDID;

import org.apache.commons.codec.binary.Base64;

public class EncodesUtil {

    /**
     * Base64编码.
     */
    public static String encodeBase64(byte[] input) {
        return Base64.encodeBase64String(input);
    }

    /**
     * Base64解码.
     */
    public static byte[] decodeBase64(String input) {
        return Base64.decodeBase64(input);
    }

}
