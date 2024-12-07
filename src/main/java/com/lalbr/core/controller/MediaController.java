package com.lalbr.core.controller;

import com.lalbr.core.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MediaController {

    @Autowired
    MediaService mediaservice;


    @GetMapping("/books")
    public String bookGetMapping(){
        return "media/booktemplate";
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
