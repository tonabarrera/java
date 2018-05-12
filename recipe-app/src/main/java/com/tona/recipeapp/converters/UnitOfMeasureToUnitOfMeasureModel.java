package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.UnitOfMeasure;
import com.tona.recipeapp.models.UnitOfMeasureModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureModel implements Converter<UnitOfMeasure, UnitOfMeasureModel> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureModel convert(UnitOfMeasure unitOfMeasure) {

        final UnitOfMeasureModel uomc = new UnitOfMeasureModel();
        uomc.setId(unitOfMeasure.getId());
        uomc.setDescription(unitOfMeasure.getDescription());
        return uomc;
    }
}