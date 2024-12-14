package com.lalbr.core.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public RecipeModel findRezeptModelByName(String name) {
        return recipeRepository.findRezeptModelByName(name);
    }

    public List<RecipeModel> findAllRezeptModel() {
        return recipeRepository.findAll();
    }

    public List<IngredientModel> findAllIngredientModel() {return ingredientRepository.findAll();}

    public RecipeModel saveRezeptModel(RecipeModel recipeModel) {
        return recipeRepository.save(recipeModel);
    }
}
