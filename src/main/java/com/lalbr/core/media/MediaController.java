package com.lalbr.core.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MediaController {

    @Autowired
    MediaService mediaservice;

    // MEDIA OVERVIEW
    @GetMapping("/books")
    public String bookGetMapping(Model model){
        model.addAttribute("booklist", mediaservice.findAllBookModel());
        model.addAttribute("bookserieslist",mediaservice.findAllBookSeriesModel());
        model.addAttribute("gameslist",mediaservice.findAllGameModel());
        model.addAttribute("movielist",mediaservice.findAllMovieModel());
        return "media/mediaoverview";
    }

    @GetMapping(value = {"/book/{name}","/Book/{name}"})
    public String bookTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("book",mediaservice.findBookModelByTitle(name));
        return "/media/booktemplate";
    }

    @GetMapping("/bookseries")
    public String bookseriesGetMapping(Model model){
        model.addAttribute("bookseries", mediaservice.findAllBookSeriesModel());
        return "media/mediaoverview";
    }

    @GetMapping(value = {"/bookseries/{name}","/Bookseries/{name}"})
    public String bookSeriesTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("bookseries",mediaservice.findBookSeriesModelByTitle(name));
        return "/media/bookseriestemplate";
    }

    @GetMapping("/game")
    public String gamesGetMapping(){
        return "media/gametemplate";
    }

    @GetMapping(value = {"/game/{name}","/Game/{name}"})
    public String gamesTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("game",mediaservice.findGameModelByTitle(name));
        return "/media/gametemplate";
    }

    @GetMapping("/movies")
    public String moviesGetMapping(){
        return "media/movietemplate";
    }

    @GetMapping(value = {"/movie/{name}","/Movie/{name}"})
    public String movieTemplateGetMapping(@PathVariable String name, Model model) {
        model.addAttribute("movie", mediaservice.findMovieModelByTitle(name));
        return "/media/movietemplate";
    }
}
