package com.mycompany.note.outbound.dao.jpa.repository;

import com.mycompany.note.outbound.dao.jpa.model.NoteEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepositoryJpa extends CrudRepository<NoteEntity, Long> {

    @Query("select note from NoteEntity note where note.owner.email=?1")
    List<NoteEntity> findByUser(String userName);

    @Query("delete from NoteEntity note where note.owner.email=?1 and note.id=?2")
    void deleteByUserNameAndId(String userName, long id);

    @Query("select note from NoteEntity note where note.owner.email=?2 and note.id=?1")
    Optional<NoteEntity> findByIdAndUserName(Long id, String userName);
}
