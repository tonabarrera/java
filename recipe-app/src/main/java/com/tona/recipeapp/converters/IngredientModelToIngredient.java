package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Ingredient;
import com.tona.recipeapp.domain.Recipe;
import com.tona.recipeapp.models.IngredientModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientModelToIngredient implements Converter<IngredientModel, Ingredient> {

    private final UnitOfMeasureModelToUnitOfMeasure uomConverter;

    public IngredientModelToIngredient(UnitOfMeasureModelToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientModel source) {
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());

        if (source.getRecipeId() != null) {
            Recipe recipe = new Recipe();
            recipe.setId(source.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.addIngredient(ingredient);
        }

        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUom()));
        return ingredient;
    }
}