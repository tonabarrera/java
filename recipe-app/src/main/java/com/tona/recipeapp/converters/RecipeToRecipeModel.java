package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Category;
import com.tona.recipeapp.domain.Recipe;
import com.tona.recipeapp.models.RecipeModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeModel implements Converter<Recipe, RecipeModel> {

    private final CategoryToCategoryModel categoryConveter;
    private final IngredientToIngredientModel ingredientConverter;
    private final NotesToNotesModel notesConverter;

    public RecipeToRecipeModel(CategoryToCategoryModel categoryConveter,
            IngredientToIngredientModel ingredientConverter, NotesToNotesModel notesConverter) {
        this.categoryConveter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeModel convert(Recipe source) {
        final RecipeModel command = new RecipeModel();
        command.setId(source.getId());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulty());
        command.setDirections(source.getDirections());
        command.setServings(source.getServings());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());
        command.setImage(source.getImage());
        command.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0) {
            source.getCategories().forEach((Category category) -> command.getCategories()
                    .add(categoryConveter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0) {
            source.getIngredients().forEach(ingredient -> command.getIngredients()
                    .add(ingredientConverter.convert(ingredient)));
        }

        return command;
    }
}