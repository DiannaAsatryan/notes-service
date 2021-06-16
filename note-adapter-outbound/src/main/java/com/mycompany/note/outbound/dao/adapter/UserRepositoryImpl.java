package com.mycompany.note.outbound.dao.adapter;

import com.mycompany.note.domain.model.User;
import com.mycompany.note.domain.repository.UserRepository;
import com.mycompany.note.outbound.dao.jpa.repository.UserRepositoryJpa;
import com.mycompany.note.outbound.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {


    @Autowired
    UserMapper mapper;

    @Autowired
    UserRepositoryJpa userRepository;


    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::convertFrom);
    }
}
