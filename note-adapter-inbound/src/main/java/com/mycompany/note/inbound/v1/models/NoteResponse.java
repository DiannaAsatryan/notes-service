package com.mycompany.note.inbound.v1.models;

import lombok.Value;

@Value
public class NoteResponse {
    Long id;
    String title;
    String node;
}
