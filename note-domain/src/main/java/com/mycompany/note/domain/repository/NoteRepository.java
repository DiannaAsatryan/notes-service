package com.mycompany.note.domain.repository;

import com.mycompany.note.domain.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    Optional<Note> findById(String userName, long noteId);

    List<Note> findAll(String userName);

    Note save(String userName, Note note);

    void deleteById(String userName, long noteId);

}
