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

    /*
        Overview Mappings
     */
    @GetMapping("/media/overview")
    public String overviewGetMapping(Model model){
        model.addAttribute("booklist", mediaservice.findAllBookModel());
        model.addAttribute("bookserieslist",mediaservice.findAllBookSeriesModel());
        model.addAttribute("gameslist",mediaservice.findAllGameModel());
        model.addAttribute("movielist",mediaservice.findAllMovieModel());
        return "media/overview/mediaoverview";
    }

    @GetMapping("/books")
    public String bookGetMapping(Model model){
        model.addAttribute("booklist", mediaservice.findAllBookModel());
        return "media/overview/bookoverview";
    }

    @GetMapping("/bookseries")
    public String bookseriesGetMapping(Model model){
        model.addAttribute("bookserieslist", mediaservice.findAllBookSeriesModel());
        return "media/overview/bookseriesoverview";
    }

    @GetMapping("/games")
    public String gamesGetMapping(Model model){
        model.addAttribute("gameslist",mediaservice.findAllGameModel());
        return "media/overview/gameoverview";
    }

    @GetMapping("/movies")
    public String moviesGetMapping(Model model){
        model.addAttribute("movielist",mediaservice.findAllMovieModel());
        return "media/overview/movieoverview";
    }



    /*
        Detail templates
     */

    @GetMapping(value = {"/book/{name}","/Book/{name}"})
    public String bookTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("book",mediaservice.findBookModelByTitle(name));
        return "/media/detailtemplates/booktemplate";
    }

    @GetMapping(value = {"/movie/{name}","/Movie/{name}"})
    public String movieTemplateGetMapping(@PathVariable String name, Model model) {
        model.addAttribute("movie", mediaservice.findMovieModelByTitle(name));
        return "/media/detailtemplates/movietemplate";
    }

    @GetMapping(value = {"/game/{name}","/Game/{name}"})
    public String gamesTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("game",mediaservice.findGameModelByTitle(name));
        return "/media/detailtemplates/gametemplate";
    }

    @GetMapping(value = {"/bookseries/{name}","/Bookseries/{name}"})
    public String bookSeriesTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("bookseries",mediaservice.findBookSeriesModelByTitle(name));
        return "/media/detailtemplates/bookseriestemplate";
    }
}
