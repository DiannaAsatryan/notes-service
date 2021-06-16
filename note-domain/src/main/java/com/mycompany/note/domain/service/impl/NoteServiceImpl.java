package com.mycompany.note.domain.service.impl;

import com.mycompany.note.domain.exception.ResourceNotFoundException;
import com.mycompany.note.domain.model.Note;
import com.mycompany.note.domain.model.enums.ResourceType;
import com.mycompany.note.domain.repository.NoteRepository;
import com.mycompany.note.domain.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;


    /**
     * Return note by id
     * ResourceNotFoundException will be thrown if note not found in database by given noteId
     *
     * @param userName User name of logged in user
     * @param noteId   Id of note which need to be retrieved
     * @return Note
     */
    public Note getNote(String userName, long noteId) {
        Optional<Note> note = noteRepository.findById(userName, noteId);
        if (!note.isPresent()) {
            throw new ResourceNotFoundException(ResourceType.note, String.valueOf(noteId));
        }
        return note.get();
    }

    /**
     * Get all notes
     *
     * @param userName User name of logged in user
     * @return List<Note>
     */
    @Override
    public List<Note> getAllNotes(String userName) {
        return noteRepository.findAll(userName);
    }

    /**
     * Create new note by give request model
     *
     * @param userName User name of logged in user
     * @param note     Note model contents note information
     * @return note
     */
    @Override
    public Note createNote(String userName, Note note) {

        return noteRepository.save(userName, note);
    }

    /**
     * Update note in database
     * Throws ResourceNotFoundException if note not found in database by given noteId
     *
     * @param userName    User name of logged in user
     * @param noteId      Id of note which need to be updated
     * @param noteRequest Note model contents note information
     * @return note
     */
    @Override
    public Note updateNote(String userName, long noteId, Note noteRequest)
        throws ResourceNotFoundException
    {
        Optional<Note> noteOpt = noteRepository.findById(userName, noteId);
        if (!noteOpt.isPresent()) {
            throw new ResourceNotFoundException(ResourceType.note, String.valueOf(noteId));
        }
        Note note = noteOpt.get();
        note.setTitle(noteRequest.getTitle());
        note.setNote(noteRequest.getNote());
        return noteRepository.save(userName, note);
    }

    /**
     * Remove note from database
     *
     * @param userName User name of logged in user
     * @param noteId   Id of note which need to be removed
     */
    @Override
    public void removeNote(String userName, long noteId) {
        noteRepository.deleteById(userName, noteId);
    }
}
