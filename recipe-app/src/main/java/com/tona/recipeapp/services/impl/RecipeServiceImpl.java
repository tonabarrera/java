package com.tona.recipeapp.services.impl;

import com.tona.recipeapp.converters.RecipeModelToRecipe;
import com.tona.recipeapp.converters.RecipeToRecipeModel;
import com.tona.recipeapp.domain.Recipe;
import com.tona.recipeapp.models.RecipeModel;
import com.tona.recipeapp.repositories.RecipeRepository;
import com.tona.recipeapp.services.RecipeService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service("recipeServiceImpl")
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeModelToRecipe recipeModelToRecipe;
    private final RecipeToRecipeModel recipeToRecipeModel;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeModelToRecipe
            recipeModelToRecipe, RecipeToRecipeModel recipeToRecipeModel){
        this.recipeRepository = recipeRepository;
        this.recipeModelToRecipe = recipeModelToRecipe;
        this.recipeToRecipeModel = recipeToRecipeModel;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Estoy aqui en el servicio");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long l) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent()) {
            log.debug("ERROR EN findById");
        } else {
            return recipeOptional.get();
        }
        return null;
    }

    @Override
    @Transactional
    public RecipeModel findCommandById(Long l) {
        return recipeToRecipeModel.convert(findById(l));
    }

    @Override
    public RecipeModel saveRecipeModel(RecipeModel command) {
        Recipe detachedRecipe = recipeModelToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeModel.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long idToDelete) {
        recipeRepository.deleteById(idToDelete);
    }
}
