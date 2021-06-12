package com.mycompany.note.outbound.dao.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
@Data
@NoArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @JoinTable(name = "user_note",
        joinColumns = @JoinColumn(name = "note_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToOne
    private UserEntity owner;
    private Long createdAt;

    public NoteEntity(Long id, String name, String description,
        UserEntity owner)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
    }
}
