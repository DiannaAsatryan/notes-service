package com.mycompany.note.outbound.dao.mapper;

import com.mycompany.note.domain.model.Note;
import com.mycompany.note.outbound.dao.jpa.model.NoteEntity;
import com.mycompany.note.outbound.dao.jpa.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public NoteEntity convertTo(Note note, UserEntity owner) {
        return NoteEntity.builder()
            .id(note.getId())
            .owner(owner)
            .title(note.getTitle())
            .note(note.getNote())
            .build();
    }

    public Note convertFrom(NoteEntity note) {
        if (note == null) {
            return null;
        }
        return Note.builder()
            .id(note.getId())
            .title(note.getTitle())
            .note(note.getNote())
            .build();
    }

    public List<Note> convertFrom(List<NoteEntity> notes) {
        return notes.stream()
            .map(this::convertFrom)
            .collect(Collectors.toList());
    }
}
