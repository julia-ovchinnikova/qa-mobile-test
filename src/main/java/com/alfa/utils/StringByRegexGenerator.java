package com.alfa.utils;

import java.util.Random;

public class StringByRegexGenerator {

    public static String getRandomString(String regex, int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        int n;

        while (length > 0) {
            //random number between 33 - 126
            n = random.nextInt(94) + 33;
            char c = (char) n;
            if (Character.toString(c).matches(regex)) {
                randomString.append(c);
            } else {
                continue;
            }
            length--;
        }
        return randomString.toString();
    }
}
