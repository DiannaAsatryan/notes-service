package com.mycompany.note.domain.repository;

import com.mycompany.note.domain.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Optional<Note> findById(long noteId);

    List<Note> findAll(long userId);

    Note save(Note note);

    void deleteById(long noteId);

}
