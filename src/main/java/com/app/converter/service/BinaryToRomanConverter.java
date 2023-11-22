package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import com.app.converter.utils.ConverterUtil;
import org.springframework.util.StringUtils;

public class BinaryToRomanConverter implements Converter {

    @Override
    public String convert(String binary) {
        if (StringUtils.isEmpty(binary)) {
            throw new NumeralException("Binary input cannot be null");
        }
        if (!isValidBinary(binary)) {
            throw new NumeralException("Invalid binary input: " + binary);
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
