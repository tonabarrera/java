package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Category;
import com.tona.recipeapp.models.CategoryModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryModelToCategory implements Converter<CategoryModel, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryModel source) {

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}