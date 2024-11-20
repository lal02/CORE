package com.lalbr.core.controller;

import com.lalbr.core.model.RezeptModel;
import com.lalbr.core.services.RezeptService;
import com.lalbr.core.util.Recipe.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RezepteController {

    @Autowired
    RezeptService rezeptService;

    @GetMapping(value = {"/rezepte/{name}","/Rezepte/{name}"})
    public String rezepteTemplateGetMapping(@PathVariable String name, Model model){
        model.addAttribute("rezept",rezeptService.findRezeptModelByName(name));
        return "rezepte/rezeptTemplate";
    }

    @GetMapping(value={"/rezepte","/Rezepte","/rezept","/Rezept"})
    public String rezeptOverviewGetMapping(Model model){
        List<RezeptModel> list = rezeptService.findAllRezeptModel();
        list.forEach(e -> System.out.println(e.getName()));
        List<Ingredient> list2 = rezeptService.findAllIngredientModel();
        list2.forEach(e -> System.out.println(e.getId()));
        model.addAttribute("rezeptList",list);
        return "rezepte/rezepte";
    }

    @GetMapping(value = {"/rezeptersteller","/rezeptErsteller","/recipecreator","/recipeCreator","/Rezeptersteller","/RezeptErsteller","/rezeptCreator","/RezeptCreator","/Rezeptcreator"})
    public String rezepterstellerGetMapping(){
        return "rezepte/rezeptErsteller";
    }
}
