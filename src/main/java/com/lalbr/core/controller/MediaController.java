package com.lalbr.core.controller;

import com.lalbr.core.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MediaController {

    @Autowired
    MediaService mediaservice;


    @GetMapping("/books")
    public String bookGetMapping(Model model){
        model.addAttribute("booklist", mediaservice.findAllBookModel());
        return "media/mediaoverview";
    }

    @GetMapping(value = {"/book/{name}","/book/{name}"})
    public String bookTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("book",mediaservice.findBookModelByTitle(name));
        return "/media/booktemplate";
    }

    @GetMapping("/games")
    public String gamesGetMapping(){
        return "media/gametemplate";
    }

    @GetMapping("/movies")
    public String moviesGetMapping(){
        return "media/movietemplate";
    }
}
