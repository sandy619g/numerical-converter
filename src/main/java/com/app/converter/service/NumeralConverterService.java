package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

@Component
public class NumeralConverterService {

    public String convertNum(String conversionType, String numeral) throws Exception {
        if (EnumUtils.isValidEnum(ConverterFactory.class, conversionType)) {
            Converter converter = ConverterFactory.valueOf(conversionType.toUpperCase())
                    .createConverter();
            return converter.convert(numeral);
        } else {
            throw new NumeralException("Invalid Conversion Type");
        }
    }
}
