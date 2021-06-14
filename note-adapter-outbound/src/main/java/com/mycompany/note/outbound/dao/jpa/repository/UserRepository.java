package com.mycompany.note.outbound.dao.jpa.repository;

import com.mycompany.note.outbound.dao.jpa.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
