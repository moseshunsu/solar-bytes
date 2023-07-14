package com.sunpower.utils;

import java.util.Random;

public class ResponseUtils {

    public static final String USER_EXISTS_CODE = "001";
    public static final String USER_EXISTS_MESSAGE = "Customer with provided email or username already exists!";
    public static final String PASSWORD_MISMATCH_CODE = "002";
    public static final String PASSWORD_MISMATCH_MESSAGE = "Passwords provided do not match!";
    public static final String USER_SUCCESS_CODE = "003";
    public static final String CUSTOMER_SUCCESS_MESSAGE = "Customer registration successful!";
    public static final String ADMIN_SUCCESS_MESSAGE = "Customer registration successful!";
    public static final String PRODUCT_EXISTS_CODE = "004";
    public static final String PRODUCT_EXISTS_MESSAGE = "Product with provided units already exists!";
    public static final String PRODUCT_SUCCESS_CODE = "005";
    public static final String PRODUCT_SUCCESS_MESSAGE = "Product registration successful!";
    public static final String TRANSACTION_SUCCESS_CODE = "006";
    public static final String TRANSACTION_SUCCESS_MESSAGE = "Units purchased successful!";
    public static final String INVALID_METER_CODE = "007";
    public static final String INVALID_METER_MESSAGE = "Invalid meter number!";
    public static final String FAQ_SUCCESS_CODE = "008";
    public static final String FAQ_SUCCESS_MESSAGE = "FAQ successfully entered!";

    public static String generateControllerNumber(int length) {
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
