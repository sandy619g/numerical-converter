package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import com.app.converter.utils.ConverterUtil;
import org.springframework.util.StringUtils;

public class DecimalToRomanConverter implements Converter {
    @Override
    public String convert(String numeral) {
        if(StringUtils.isEmpty(numeral)){
            throw new NumeralException("Invalid Numeral value");
        }
        int num = Integer.parseInt(numeral);
        return ConverterUtil.getDecimalToRomanConversion(num);
    }
}
