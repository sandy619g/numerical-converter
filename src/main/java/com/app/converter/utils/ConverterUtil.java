package com.app.converter.utils;

public final class ConverterUtil {
    public static String getDecimalToRomanConversion(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
        String[] romanSymbols = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        StringBuilder result = new StringBuilder();
        int i = values.length - 1;

        while (num > 0) {
            if (num >= values[i]) {
                result.append(romanSymbols[i]);
                num -= values[i];
            } else {
                i--;
            }
        }
        return result.toString();
    }

}