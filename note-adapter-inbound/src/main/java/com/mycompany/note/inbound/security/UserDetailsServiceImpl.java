package com.mycompany.note.inbound.security;

import com.mycompany.note.domain.model.User;
import com.mycompany.note.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByEmail(username);
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
            .password(user.getPassword())
            .authorities("USER")
            .build();
    }

}

