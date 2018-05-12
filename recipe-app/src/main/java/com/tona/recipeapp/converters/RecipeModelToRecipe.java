package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Recipe;
import com.tona.recipeapp.models.RecipeModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeModelToRecipe implements Converter<RecipeModel, Recipe> {

    private final CategoryModelToCategory categoryConveter;
    private final IngredientModelToIngredient ingredientConverter;
    private final NotesModelToNotes notesConverter;

    public RecipeModelToRecipe(CategoryModelToCategory categoryConveter,
            IngredientModelToIngredient ingredientConverter, NotesModelToNotes notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeModel model) {
        final Recipe recipe = new Recipe();
        recipe.setId(model.getId());
        recipe.setCookTime(model.getCookTime());
        recipe.setPrepTime(model.getPrepTime());
        recipe.setDescription(model.getDescription());
        recipe.setDifficulty(model.getDifficulty());
        recipe.setDirections(model.getDirections());
        recipe.setServings(model.getServings());
        recipe.setSource(model.getSource());
        recipe.setUrl(model.getUrl());
        recipe.setNotes(notesConverter.convert(model.getNotes()));

        if (model.getCategories() != null && model.getCategories().size() > 0){
            model.getCategories()
                    .forEach( category -> recipe.getCategories().add(categoryConveter.convert(category)));
        }

        if (model.getIngredients() != null && model.getIngredients().size() > 0){
            model.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return recipe;
    }
}
