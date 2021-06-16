package com.mycompany.note.domain.service.impl;

import com.mycompany.note.domain.exception.ResourceNotFoundException;
import com.mycompany.note.domain.model.User;
import com.mycompany.note.domain.model.enums.ResourceType;
import com.mycompany.note.domain.repository.UserRepository;
import com.mycompany.note.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException(ResourceType.user, email);
        }
        return user.get();
    }
}
