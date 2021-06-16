package com.mycompany.note.outbound.dao.adapter;

import com.mycompany.note.domain.exception.RepositoryExtension;
import com.mycompany.note.domain.model.Note;
import com.mycompany.note.domain.repository.NoteRepository;
import com.mycompany.note.outbound.dao.jpa.model.NoteEntity;
import com.mycompany.note.outbound.dao.jpa.model.UserEntity;
import com.mycompany.note.outbound.dao.jpa.repository.NoteRepositoryJpa;
import com.mycompany.note.outbound.dao.jpa.repository.UserRepositoryJpa;
import com.mycompany.note.outbound.dao.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteRepositoryImpl implements NoteRepository {

    @Autowired
    NoteMapper mapper;

    @Autowired
    NoteRepositoryJpa noteRepository;

    @Autowired
    UserRepositoryJpa userRepository;

    @Override
    public Optional<Note> findById(String userName, long noteId) {
        return noteRepository.findByIdAndUserName(noteId, userName).map(mapper::convertFrom);
    }

    @Override
    public List<Note> findAll(String userName) {
        return mapper.convertFrom(noteRepository.findByUser(userName));
    }

    @Override
    public Note save(String userName, Note note) {
        Optional<UserEntity> owner = userRepository.findByEmail(userName);
        if (owner.isEmpty()) {
            throw new RepositoryExtension("Note's owner not found");
        }
        NoteEntity entity = mapper.convertTo(note, owner.get());
        return mapper.convertFrom(noteRepository.save(entity));
    }

    @Override
    public void deleteById(String userName, long noteId) {
        noteRepository.deleteByUserNameAndId(userName, noteId);
    }
}
