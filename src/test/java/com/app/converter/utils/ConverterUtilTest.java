package com.app.converter.utils;

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
        assertThrows(IllegalArgumentException.class, () -> ConverterUtil.getDecimalToRomanConversion(-5));
    }

}

