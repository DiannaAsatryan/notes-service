package com.mycompany.note.outbound.dao.jpa.repository;

import com.mycompany.note.outbound.dao.jpa.model.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<NoteEntity, Long>{

   List<NoteEntity> findByOwnerId(long ownerId);
}
