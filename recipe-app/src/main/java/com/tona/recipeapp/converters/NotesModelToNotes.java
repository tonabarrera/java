package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Notes;
import com.tona.recipeapp.models.NotesModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesModelToNotes implements Converter<NotesModel, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesModel source) {
        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}