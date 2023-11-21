package com.app.converter.service;

import com.app.converter.utils.ConverterUtil;

public class DecimalToRomanConverter implements Converter {
    @Override
    public String convert(String numeral) {
        int num = Integer.parseInt(numeral);
        return ConverterUtil.getDecimalToRomanConversion(num);
    }
}
