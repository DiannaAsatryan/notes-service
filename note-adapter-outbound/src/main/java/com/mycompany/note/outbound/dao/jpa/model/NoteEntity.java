package com.mycompany.note.outbound.dao.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String note;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private UserEntity owner;

    private Long createdAt = System.currentTimeMillis();
    private Long updatedAt = System.currentTimeMillis();

    public NoteEntity(String title, String note,
        UserEntity owner)
    {
        this.title = title;
        this.note = note;
        this.owner = owner;
        this.createdAt = this.updatedAt = System.currentTimeMillis();
    }
}
