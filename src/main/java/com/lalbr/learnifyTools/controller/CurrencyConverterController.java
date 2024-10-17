package com.lalbr.learnifyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyConverterController {

    @GetMapping("/converter")
    public String converter() {
        return "currencyConverter";
    }
}
