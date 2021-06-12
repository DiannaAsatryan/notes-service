package com.mycompany.note.outbound.dao.repositories;

import com.mycompany.note.outbound.dao.models.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
}
