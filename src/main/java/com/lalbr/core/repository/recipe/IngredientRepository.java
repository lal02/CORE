package com.lalbr.core.repository.recipe;

import com.lalbr.core.util.Recipe.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {

}