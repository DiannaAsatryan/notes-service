package com.mycompany.note.inbound.v1.mapper;

import com.mycompany.note.domain.model.Note;
import com.mycompany.note.inbound.v1.models.CreateNoteRequest;
import com.mycompany.note.inbound.v1.models.NoteResponse;
import com.mycompany.note.inbound.v1.models.UpdateNoteRequest;

import java.util.List;
import java.util.stream.Collectors;

public class NoteMapper {
    public Note mapCreate(CreateNoteRequest request) {
        return Note.builder()
            .note(request.getNote())
            .title(request.getTitle())
            .build();
    }

    public Note mapUpdate(UpdateNoteRequest request) {
        return Note.builder()
            .note(request.getNote())
            .title(request.getTitle())
            .build();
    }

    public List<NoteResponse> mapResponse(List<Note> notes) {
        return notes.stream()
            .map(this::mapResponse)
            .collect(Collectors.toList());
    }

    public NoteResponse mapResponse(Note note) {
        return new NoteResponse(note.getId(), note.getTitle(), note.getNote());
    }
}
