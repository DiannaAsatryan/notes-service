package com.mycompany.note.domain.service.impl;

import com.mycompany.note.domain.model.Note;
import com.mycompany.note.domain.model.enums.ResourceType;
import com.mycompany.note.domain.repository.NoteRepository;
import com.mycompany.note.domain.service.NoteService;
import com.mycompany.note.domain.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    /**
     * Return note by id ResourceNotFoundException will be thrown if note not found in database by given
     * noteId
     *
     * @param noteId Id of note which need to be retrieved
     * @return Note
     */
    public Note getNote(long noteId) {
        Optional<Note> note = noteRepository.findById(noteId);
        if (!note.isPresent()) {
            throw new ResourceNotFoundException(ResourceType.note, noteId);
        }
        return note.get();
    }

    /**
     * Get all notes
     *
     * @return List<Note>
     */
    @Override
    public List<Note> getAllNotes(long userId) {
        return noteRepository.findAll(userId);
    }

    /**
     * Create new note by give request model
     *
     * @param note Note model contents note information
     * @return note
     */
    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Update note in database, only fields present in UpdatenoteRequest will be changed
     * Throws ResourceNotFoundException if note not found in database by given noteId
     *
     * @param noteId Id of note which need to be updated
     * @param noteRequest   Note model contents note information
     * @return note
     */
    @Override
    public Note updateNote(long noteId, Note noteRequest)
        throws ResourceNotFoundException
    {
        Optional<Note> noteOpt = noteRepository.findById(noteId);
        if (!noteOpt.isPresent()) {
            throw new ResourceNotFoundException(ResourceType.note, noteId);
        }
        Note note = noteOpt.get();
        note.setTitle(noteRequest.getTitle());
        note.setNote(noteRequest.getNote());
        return noteRepository.save(note);
    }

    /**
     * Remove note from database
     *
     * @param noteId Id of note which need to be removed
     */
    @Override
    public void removeNote(long noteId) {
        noteRepository.deleteById(noteId);
    }
}
