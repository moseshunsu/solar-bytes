package com.sunpower.utils;

import java.util.Random;

public class ResponseUtils {

    public static final String USER_EXISTS_CODE = "001";
    public static final String USER_EXISTS_MESSAGE = "Customer with provided email already exists!";
    public static final String PASSWORD_MISMATCH_CODE = "002";
    public static final String PASSWORD_MISMATCH_MESSAGE = "Passwords provided do mot match!";
    public static final String SUCCESS = "003";
    public static final String USER_SUCCESS_MESSAGE = "Customer registration successful!";

    public static String generateMeterNumber(int length) {
        String meterNumber = "";
        int x;
        char[] stringChars = new char[length];

        for (int i = 0; i < length; i++) {
            Random random = new Random();
            x = random.nextInt(9);

            stringChars[i] = Integer.toString(x).toCharArray()[0];
        }

        meterNumber = new String(stringChars);
        return meterNumber.trim();
    }

}
