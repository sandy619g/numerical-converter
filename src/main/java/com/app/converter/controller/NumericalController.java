package com.app.converter.controller;

import com.app.converter.exception.CustomException;
import com.app.converter.exception.NumeralException;
import com.app.converter.service.NumeralConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/numerical-converter")
public class NumericalController {

    @Autowired
    public NumeralConverterService service;

    @GetMapping("/{type}/{numeral}")
    public ResponseEntity<?> convert(@PathVariable String type, @PathVariable String numeral) {
        try {
            String result = service.convertNum(String.valueOf(type), numeral);
            return ResponseEntity.ok(result);
        }
        catch (Exception e) {
            throw new NumeralException(e.getMessage());
        }
    }
}
