package com.mycompany.note.domain.service;

import com.mycompany.note.domain.model.User;

public interface UserService {
    User findByEmail(String email);
}
