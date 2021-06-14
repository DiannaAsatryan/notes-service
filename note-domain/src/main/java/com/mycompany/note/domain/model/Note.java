package com.mycompany.note.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Note {
    Long id;
    String title;
    String note;
    Long ownerId = 1l;
}
