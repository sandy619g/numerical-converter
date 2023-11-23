package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NumeralConverterService {

    public String convertNum(ConverterFactory conversionType, String numeral) throws Exception {
        if (ObjectUtils.isEmpty(conversionType) || StringUtils.isEmpty(numeral)) {
            throw new NumeralException("Conversion Type or Numeral is invalid");
        } else {
            Converter converter = conversionType.createConverter();
            return converter.convert(numeral);
        }
    }
}
