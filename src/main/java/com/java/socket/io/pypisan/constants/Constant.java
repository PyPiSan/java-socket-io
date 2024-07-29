package com.java.socket.io.pypisan.constants;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Constant {

    public static final String success = "success";
    public static final String failed = "failed";
    public static final String userRequired = "user name required";
    public static final String emailRequired = "email id required";
    public static final String profileUrlRequired = "profile url required";
    public static final String userExists = "this email is already registered";
    public static final String WELCOME_MESSAGE = "connection created successfuuly";
    public static final String DISCONNECT_MESSAGE = "thanks for using";

    public static String encryptpassword(String password) {
        String encryptedpassword = null;
        try {
            /* MessageDigest instance for MD5. */
            MessageDigest m = MessageDigest.getInstance("MD5");

            /* Add plain-text password bytes to digest using MD5 update() method. */
            m.update(password.getBytes());

            /* Convert the hash value into bytes */
            byte[] bytes = m.digest();

            /*
             * The bytes array has bytes in decimal form. Converting it into hexadecimal
             * format.
             */
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            /* Complete hashed password in hexadecimal format */
            encryptedpassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedpassword;
    }

}
