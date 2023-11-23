package com.app.converter.controller;

import com.app.converter.audit.service.AuditLogService;
import com.app.converter.exception.NumeralException;
import com.app.converter.service.ConverterFactory;
import com.app.converter.service.NumeralConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/numerical-converter")
public class NumericalController {

    @Autowired
    public NumeralConverterService service;

    @Autowired
    public AuditLogService auditLogService;

    @GetMapping
    public ResponseEntity<?> convert(@RequestParam ConverterFactory type, @RequestParam String numeral) {
        try {
            String result = service.convertNum(type, numeral);
            auditLogService.logConversion(String.valueOf(type), numeral, result);
            return ResponseEntity.ok(result);
        }
        catch (Exception e) {
            throw new NumeralException(e.getMessage());
        }
    }
}
