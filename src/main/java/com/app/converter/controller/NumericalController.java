package com.app.converter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/numerical-converter")
public class NumericalController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
