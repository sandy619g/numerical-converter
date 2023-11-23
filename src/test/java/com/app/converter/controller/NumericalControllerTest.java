package com.app.converter.controller;

import com.app.converter.audit.service.AuditLogService;
import com.app.converter.exception.NumeralException;
import com.app.converter.service.ConverterFactory;
import com.app.converter.service.NumeralConverterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class NumericalControllerTest {

    @Mock
    private NumeralConverterService service;

    @Mock
    private AuditLogService auditLogService;

    @InjectMocks
    private NumericalController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testConvert() throws Exception {

        String numeral = "123";
        ConverterFactory type = ConverterFactory.DECIMAL_TO_ROMAN;
        String expectedResult = "CXXIII";

        when(service.convertNum(type, numeral)).thenReturn(expectedResult);

        mockMvc.perform(get("/api/v1/numerical-converter")
                        .param("type", type.name())
                        .param("numeral", numeral)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult));

        verify(auditLogService, times(1)).logConversion(String.valueOf(type), numeral, expectedResult);
    }
}