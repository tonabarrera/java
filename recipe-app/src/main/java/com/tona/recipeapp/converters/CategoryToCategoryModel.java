package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Category;
import com.tona.recipeapp.models.CategoryModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryModel implements Converter<Category, CategoryModel> {

    @Synchronized
    @Nullable
    @Override
    public CategoryModel convert(Category source) {

        final CategoryModel categoryCommand = new CategoryModel();

        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }
}
