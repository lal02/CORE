package com.lalbr.core.services;

import com.lalbr.core.model.RezeptModel;
import com.lalbr.core.repository.recipe.IngredientRepository;
import com.lalbr.core.repository.recipe.RezeptRepository;
import com.lalbr.core.util.Recipe.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezeptService {

    @Autowired
    private RezeptRepository rezeptRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public RezeptModel findRezeptModelByName(String name) {
        return rezeptRepository.findRezeptModelByName(name);
    }

    public List<RezeptModel> findAllRezeptModel() {
        return rezeptRepository.findAll();
    }

    public List<Ingredient> findAllIngredientModel() {return ingredientRepository.findAll();}

    public RezeptModel saveRezeptModel(RezeptModel rezeptModel) {
        return rezeptRepository.save(rezeptModel);
    }
}
