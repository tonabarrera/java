package com.tona.recipeapp.converters;

import com.tona.recipeapp.domain.Notes;
import com.tona.recipeapp.models.NotesModel;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesModel implements Converter<Notes, NotesModel> {

    @Synchronized
    @Nullable
    @Override
    public NotesModel convert(Notes source) {

        final NotesModel notesCommand = new NotesModel();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNotes());
        return notesCommand;
    }
}