package com.mycompany.note.inbound.v1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNoteRequest {
    @NotNull
    @Max(500)
    private String title;
    @NotNull
    @Max(1000)
    private String note;
}
