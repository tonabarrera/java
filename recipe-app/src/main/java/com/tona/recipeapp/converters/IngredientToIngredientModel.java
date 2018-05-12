package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Ingredient;
import com.tona.recipeapp.models.IngredientModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientModel implements Converter<Ingredient, IngredientModel> {

    private final UnitOfMeasureToUnitOfMeasureModel uomConverter;

    public IngredientToIngredientModel(UnitOfMeasureToUnitOfMeasureModel uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientModel convert(Ingredient ingredient) {
        IngredientModel ingredientCommand = new IngredientModel();
        ingredientCommand.setId(ingredient.getId());
        if (ingredient.getRecipe() != null) {
            ingredientCommand.setRecipeId(ingredient.getRecipe().getId());
        }
        ingredientCommand.setAmount(ingredient.getAmount());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUom(uomConverter.convert(ingredient.getUom()));
        return ingredientCommand;
    }
}