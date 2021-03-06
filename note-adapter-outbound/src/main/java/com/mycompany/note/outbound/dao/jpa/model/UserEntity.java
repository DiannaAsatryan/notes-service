package com.mycompany.note.outbound.dao.jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "user", schema = "public")
@Data
@NoArgsConstructor
@ToString(exclude = "password")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 8)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
