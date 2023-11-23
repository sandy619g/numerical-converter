package com.app.converter.service;

import com.app.converter.exception.NumeralException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.app.converter.service.ConverterFactory.BINARY_TO_ROMAN;
import static com.app.converter.service.ConverterFactory.DECIMAL_TO_ROMAN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumeralConverterServiceTest {

    @InjectMocks
    private NumeralConverterService service;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConvertNumWithValidConversionType() throws Exception {
        String result = service.convertNum(DECIMAL_TO_ROMAN, "10");
        assertEquals("X", result);
        String binaryResult = service.convertNum(BINARY_TO_ROMAN, "1111");
        assertEquals("XV", binaryResult);
    }

    @Test
    public void testConvertNumWithInvalidConversionType() throws Exception {
        assertThrows(NumeralException.class, () ->
                service.convertNum(null, "123"));
    }
}

