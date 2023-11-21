package com.app.converter.service;

import com.app.converter.utils.ConverterUtil;

public class BinaryToRomanConverter implements Converter {

    @Override
    public String convert(String binary) {
        if (!isValidBinary(binary)) {
            throw new IllegalArgumentException("Invalid binary input: " + binary);
        }
        int decimal = binaryToDecimal(binary);
        return ConverterUtil.getDecimalToRomanConversion(decimal);
    }

    private static boolean isValidBinary(String binary) {
        return binary.matches("[01]+");
    }

    private static int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}
