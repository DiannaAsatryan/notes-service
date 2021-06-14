package com.mycompany.note.inbound.v1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteRequest {
    @NotNull
    @Size(max = 500)
    private String title;
    @NotNull
    @Size(max = 1000)
    private String note;
}
