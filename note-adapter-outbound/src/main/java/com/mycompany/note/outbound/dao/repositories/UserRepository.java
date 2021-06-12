package com.mycompany.note.outbound.dao.repositories;

import com.mycompany.note.outbound.dao.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
