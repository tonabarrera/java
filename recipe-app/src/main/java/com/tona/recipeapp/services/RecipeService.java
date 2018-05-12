package com.tona.recipeapp.services;

import com.tona.recipeapp.domain.Recipe;
import com.tona.recipeapp.models.RecipeModel;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeModel findCommandById(Long l);

    RecipeModel saveRecipeModel(RecipeModel command);

    void deleteById(Long idToDelete);
}
