package com.lalbr.learnifyTools.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RezepteController {

    @GetMapping("/rezepte")
    public String test(){
        return "rezepte";
    }

    @GetMapping("/rezepte/pizza")
    public String test2(){
        return "rezepte/pizza";
    }
}
