package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.UnitOfMeasure;
import com.tona.recipeapp.models.UnitOfMeasureModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureModelToUnitOfMeasure
        implements Converter<UnitOfMeasureModel, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureModel source) {

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
