package com.app.converter.utils;

public final class ConverterUtil {
    private static final String[] ROMAN_SYMBOLS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static final int[] VALUES = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public static String getDecimalToRomanConversion(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
        StringBuilder result = new StringBuilder();
        int i = VALUES.length - 1;
        while (num > 0) {
            if (num >= VALUES[i]) {
                result.append(ROMAN_SYMBOLS[i]);
                num -= VALUES[i];
            } else {
                i--;
            }
        }
        return result.toString();
    }

}