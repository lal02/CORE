package com.lalbr.learnifyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolsController {

    @GetMapping("/converter")
    public String converterGetMapping() {
        return "converter";
    }

    @GetMapping("/finanzrechner")
    public String finanzrechnerGetMapping(){
        return "finanzrechner";
    }

    @GetMapping("/finnishconjugation")
    public String finnConjGetMapping(){
        return "finnishConjugation";
    }

}
