package com.mycompany.note.domain.service;

import com.mycompany.note.domain.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes(long userId);

    Note getNote(long noteId);

    Note createNote(Note note);

    Note updateNote(long noteId, Note note);

    void removeNote(long noteId);


}
