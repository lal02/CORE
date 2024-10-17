package com.lalbr.learnifyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinnConjController {


    @GetMapping("/finnishConjugation")
    public String test(){
        return "finnishConjugation";
    }
}
