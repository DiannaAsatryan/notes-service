package com.mycompany.note.inbound.v1.controllers;

import com.mycompany.note.domain.service.NoteService;
import com.mycompany.note.inbound.v1.mapper.NoteMapper;
import com.mycompany.note.inbound.v1.models.CreateNoteRequest;
import com.mycompany.note.inbound.v1.models.UpdateNoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/note")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    @Qualifier("inboundNoteMapper")
    NoteMapper noteMapper;

    @GetMapping("/{noteId}")
    public ResponseEntity<?> getNoteById(@PathVariable(value = "noteId") Long noteId) {
        return ResponseEntity.ok(noteService.getNote(noteId));
    }

    @GetMapping
    public ResponseEntity<?> getAllNotes() {
        return ResponseEntity.ok(noteMapper.mapResponse(noteService.getAllNotes(1)));
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<?> updateNote(@PathVariable(value = "noteId") Long noteId,
        @RequestBody @Validated UpdateNoteRequest noteRequest)
    {
        return ResponseEntity
            .ok(noteMapper.mapResponse(noteService.updateNote(noteId, noteMapper.mapUpdate(noteRequest))));
    }

    @PostMapping
    public ResponseEntity<?> createNote(@RequestBody @Validated CreateNoteRequest noteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(noteMapper.mapResponse(noteService.createNote(noteMapper.mapCreate(noteRequest))));
    }

    @DeleteMapping("/{noteId}")
    public void removeNote(@PathVariable(value = "noteId") Long noteId) {
        noteService.removeNote(noteId);
    }

}
