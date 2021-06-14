package com.mycompany.note.outbound.dao.adapter;

import com.mycompany.note.domain.exception.RepositoryExtension;
import com.mycompany.note.domain.model.Note;
import com.mycompany.note.domain.repository.NoteRepository;
import com.mycompany.note.outbound.dao.jpa.model.NoteEntity;
import com.mycompany.note.outbound.dao.jpa.model.UserEntity;
import com.mycompany.note.outbound.dao.jpa.repository.UserRepository;
import com.mycompany.note.outbound.dao.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteRepositoryImpl implements NoteRepository {

    @Autowired
    NoteMapper mapper;

    @Autowired com.mycompany.note.outbound.dao.jpa.repository.NoteRepository noteRepository;

    @Autowired UserRepository userRepository;

    @Override
    public Optional<Note> findById(long noteId) {
        return noteRepository.findById(noteId).map(mapper::convertFrom);
    }

    @Override
    public List<Note> findAll(long userId) {
        return mapper.convertFrom(noteRepository.findByOwnerId(userId));
    }

    @Override
    public Note save(Note note) {
        Optional<UserEntity> owner = userRepository.findById(note.getOwnerId());
        if (owner.isEmpty()) {
            throw new RepositoryExtension("Note's owner not found");
        }
        NoteEntity entity = mapper.convertTo(note, owner.get());
        return mapper.convertFrom(noteRepository.save(entity));
    }

    @Override
    public void deleteById(long noteId) {
        noteRepository.deleteById(noteId);
    }
}
