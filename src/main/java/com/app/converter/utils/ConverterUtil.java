package com.app.converter.utils;

import com.app.converter.exception.NumeralException;

public final class ConverterUtil {
    public static final String m[] = { "", "M", "MM", "MMM" };
    public static final String c[] = { "",  "C",  "CC",  "CCC",  "CD",
            "D", "DC", "DCC", "DCCC", "CM" };
    public static final String x[] = { "",  "X",  "XX",  "XXX",  "XL",
            "L", "LX", "LXX", "LXXX", "XC" };
    public static final String i[] = { "",  "I",  "II",  "III",  "IV",
            "V", "VI", "VII", "VIII", "IX" };

    public static String getDecimalToRomanConversion(int num) {
        if (num <= 0 || num > 3999) {
            throw new NumeralException("Numeral should be within range 1-3999");
        }
        String thousands = m[num / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];
        return thousands + hundreds + tens + ones;
    }

}