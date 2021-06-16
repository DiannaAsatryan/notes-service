package com.mycompany.note.domain.service;

import com.mycompany.note.domain.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes(String userName);

    Note getNote(String userName, long noteId);

    Note createNote(String userName, Note note);

    Note updateNote(String userName, long noteId, Note note);

    void removeNote(String userName, long noteId);


}
