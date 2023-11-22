package com.app.converter.controller;

import com.app.converter.exception.NumeralException;
import com.app.converter.exception.NumeralResponseExceptionHandler;
import com.app.converter.service.NumeralConverterService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumericalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NumeralConverterService service;

    @InjectMocks
    private NumericalController controller;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new NumeralResponseExceptionHandler())
                .build();
    }

    @Test
    public void testConvertValidInput() throws Exception {
        when(service.convertNum("type", "numeral")).thenReturn("result");
        RequestBuilder requestBuilder = get("/api/v1/numerical-converter/type/numeral")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("result"));
    }

    @Test
    public void testConvertNumeralExceptionHandling() throws Exception {
        when(service.convertNum("type", "numeral"))
                .thenThrow(new NumeralException("Invalid Numeral value"));
        RequestBuilder requestBuilder = get("/api/v1/numerical-converter/type/numeral")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid Numeral value"));
    }
}


