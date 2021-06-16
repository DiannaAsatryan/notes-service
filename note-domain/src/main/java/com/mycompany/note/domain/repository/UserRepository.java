package com.mycompany.note.domain.repository;

import com.mycompany.note.domain.model.User;

import java.util.Optional;

public interface UserRepository {

   Optional<User> findByEmail(String email);
}
