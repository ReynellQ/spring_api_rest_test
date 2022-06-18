package com.project.market_test.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class MyFirstBean {
    @GetMapping
    public String HolaMundo(){
        return "Hola mundo";
    }
}
