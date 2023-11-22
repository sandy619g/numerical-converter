package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryToRomanConverterTest {

    @Test
    public void testConvertValidBinary() {
        BinaryToRomanConverter converter = new BinaryToRomanConverter();

        // Test case 1: Convert "1101" (binary) to Roman numeral
        String result1 = converter.convert("1101");
        assertEquals("XIII", result1);

        // Test case 2: Convert "1001" (binary) to Roman numeral
        String result2 = converter.convert("1001");
        assertEquals("IX", result2);
    }

    @Test
    public void testConvertInvalidBinary() {
        BinaryToRomanConverter converter = new BinaryToRomanConverter();

        // Test case 1: Convert an invalid binary input
        assertThrows(NumeralException.class, () -> converter.convert("abc"))
                .getMessage().contains("Invalid binary input");

        // Test case 2: Convert an empty binary input
        assertThrows(NumeralException.class, () -> converter.convert(""))
                .getMessage().contains("Invalid binary input");
    }

    @Test
    public void testConvertNullBinary() {
        BinaryToRomanConverter converter = new BinaryToRomanConverter();

        // Test case: Convert a null binary input
        assertThrows(NumeralException.class, () -> converter.convert(null))
                .getMessage().contains("Binary input cannot be null");
    }
}

