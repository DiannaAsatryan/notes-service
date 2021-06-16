package com.mycompany.note.outbound.dao.jpa.repository;

import com.mycompany.note.outbound.dao.jpa.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
