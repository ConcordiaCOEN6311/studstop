package com.concordia.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * Perform MD5 encryption for plaintext strings
     * @param source
     * @return
     */
    public static String encode(String source) {

        // 1. Determines whether a plaintext string is valid
        if (source == null || "".equals(source)) {
            throw new RuntimeException("The plaintext used for encryption cannot be empty");
        }

        // 2.Declare algorithm name
        String algorithm = "md5";

        // 3.Get the MessageDigest object
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 4.Get the byte array corresponding to the plaintext string
        byte[] input = source.getBytes();

        // 5.Perform encryption
        byte[] output = messageDigest.digest(input);

        // 6.Create a BigInteger object
        int signum = 1;
        BigInteger bigInteger = new BigInteger(signum, output);

        // 7.Convert the value of bigInteger to a string in hexadecimal
        int radix = 16;
        String encoded = bigInteger.toString(radix).toUpperCase();

        return encoded;
    }
}