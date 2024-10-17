package com.lalbr.learnifyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZinsesZinsController {

    @GetMapping("/finanzrechner")
    public String test(){
        return "zinseszins";
    }

}
