package com.mono40.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * Created by yinfante on 8/22/17.
 */
public class PasswordGenerator {

    private static Logger logger = LogManager.getLogger(PasswordGenerator.class);

    public static final String NUMBERS = "123456789";
    public static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String randomPassword() {
        logger.debug("Generating randomPassword using random() : ");

        // Using random method
        Random rndm_method = new Random();

        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            otp.append(ALPHABET_LOWER.charAt(rndm_method.nextInt(ALPHABET_LOWER.length())));
        }

        for (int i = 0; i < 3; i++) {
            otp.append(NUMBERS.charAt(rndm_method.nextInt(NUMBERS.length())));
        }

        for (int i = 0; i < 2; i++) {
            otp.append(ALPHABET_UPPER.charAt(rndm_method.nextInt(ALPHABET_UPPER.length())));
        }
        logger.info("otp : "+ otp );
        return otp.toString();
    }

    public static String generateRamdonOTP(int len) {
        logger.debug("Generating OTP using random() : ");

        // Using numeric values
        String numbers = "0123456789";

        // Using random method
        Random rndm_method = new Random();

        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < len; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp.append(numbers.charAt(rndm_method.nextInt(numbers.length())));
        }
        return otp.toString();
    }
}
