package com.mycompany.note.outbound.dao.adapter;

import com.mycompany.note.domain.model.Note;
import com.mycompany.note.domain.repository.NoteRepository;
import com.mycompany.note.outbound.dao.jpa.model.NoteEntity;
import com.mycompany.note.outbound.dao.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class NoteRepositoryImpl implements NoteRepository {

    @Autowired
    NoteMapper mapper;

    @Autowired com.mycompany.note.outbound.dao.jpa.repository.NoteRepository noteRepository;

    @Override
    public Optional<Note> findById(long noteId) {
        return Optional.ofNullable(mapper.convertFrom(noteRepository.getById(noteId)));
    }

    @Override
    public List<Note> findAll(long userId) {
        return mapper.convertFrom(noteRepository.findByOwnerId(userId));
    }

    @Override
    public Note save(Note note) {
        NoteEntity entity = mapper.convertTo(note);
        return mapper.convertFrom(noteRepository.save(entity));
    }

    @Override
    public void deleteById(long noteId) {
        noteRepository.deleteById(noteId);
    }
}
