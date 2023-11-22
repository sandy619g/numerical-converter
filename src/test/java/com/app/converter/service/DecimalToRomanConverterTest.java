package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DecimalToRomanConverterTest {

    private DecimalToRomanConverter converter = new DecimalToRomanConverter();
    @Test
    public void testConvertValidDecimal() {

        // Test case 1: Convert 13 to Roman numeral
        String result1 = converter.convert("13");
        assertEquals( "XIII", result1);

        // Test case 2: Convert 9 to Roman numeral
        String result2 = converter.convert("9");
        assertEquals( "IX", result2);
    }

    @Test
    public void testConvertInvalidDecimal() {
        DecimalToRomanConverter converter = new DecimalToRomanConverter();

        // Test case 1: Convert an invalid decimal input
        assertThrows(NumberFormatException.class, () -> converter.convert("abc"));

        // Test case 2: Convert an empty decimal input
        NumeralException exception = assertThrows(NumeralException.class, () -> converter.convert(""));
        assertEquals("Invalid Numeral value", exception.getMessage());
    }
}

