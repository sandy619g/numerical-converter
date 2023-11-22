package com.app.converter.utils;

import com.app.converter.exception.NumeralException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConverterUtilTest {

    @Test
    void testGetDecimalToRomanConversion() {
        assertEquals("XXIII", ConverterUtil.getDecimalToRomanConversion(23));
        assertEquals("XCIV", ConverterUtil.getDecimalToRomanConversion(94));
        assertEquals("C", ConverterUtil.getDecimalToRomanConversion(100));
    }

    @Test
    void testGetDecimalToRomanConversionWithInvalidInput() {
        assertThrows(NumeralException.class, () -> ConverterUtil.getDecimalToRomanConversion(-5));
    }

}

