package com.mycompany.note.outbound.dao.mapper;

import com.mycompany.note.domain.model.User;
import com.mycompany.note.outbound.dao.jpa.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User convertFrom(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return User.builder()
            .userName(userEntity.getEmail())
            .password(userEntity.getPassword())
            .build();
    }

}
