package com.mycompany.note.service;


import com.mycompany.note.domain.exception.ResourceNotFoundException;
import com.mycompany.note.domain.model.Note;
import com.mycompany.note.domain.repository.NoteRepository;
import com.mycompany.note.domain.service.NoteService;
import com.mycompany.note.domain.service.impl.NoteServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = NoteServiceImpl.class)
public class NoteServiceTest {


    private static final Long TEST_NOTE_ID = 1l;
    private static final String TEST_USER_NAME = "Dina";

    @MockBean
    private NoteRepository repository;

    @Autowired
    private NoteService noteService;

    @Test
    public void getAllNotesSuccess() {
        Note note = createNote();
        List<Note> list = List.of(note, note, note);
        when(repository.findAll(TEST_USER_NAME)).thenReturn(list);
        List<Note> notes = noteService.getAllNotes(TEST_USER_NAME);
        assertTrue("Notes count in repository and from service should be same", notes.size() == list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), notes.get(i));
        }
        assertTrue("Notes count in repository and from service should be same", notes.size() == list.size());
        verify(repository, times(1)).findAll(TEST_USER_NAME);
    }

    ;

    @Test
    public void getNoteByIdSuccess() {
        Note entity = createNote();
        when(repository.findById(anyString(), anyLong())).thenReturn(Optional.of(entity));
        Note note = noteService.getNote(TEST_USER_NAME, TEST_NOTE_ID);
        assertEquals(entity, note);
        verify(repository, times(1)).findById(anyString(), anyLong());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void getNoteByIdNotFound() {
        Note entity = createNote();
        when(repository.findById(anyString(), anyLong())).thenReturn(Optional.empty());
        Note note = noteService.getNote(TEST_USER_NAME, TEST_NOTE_ID);
        verify(repository, times(1)).findById(anyString(), anyLong());
    }

    @Test
    public void createNoteSuccess() {
        Note request = createNote();
        Note entity = createNote();
        when(repository.save(anyString(), any())).thenReturn(entity);
        Note note = noteService.createNote(TEST_USER_NAME, request);
        assertEquals(entity, note);
        verify(repository, times(1)).save(anyString(), any());
    }


    @Test
    public void updateNoteSuccess() {
        Note request = createNote();
        Note entity = createNote();
        when(repository.save(anyString(), any())).thenReturn(entity);
        when(repository.findById(anyString(), anyLong())).thenReturn(Optional.of(entity));
        Note note = noteService.updateNote(TEST_USER_NAME, TEST_NOTE_ID, request);
        assertEquals(entity, note);
        verify(repository, times(1)).save(anyString(), any());
        verify(repository, times(1)).findById(anyString(), anyLong());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updateNoteFail() {
        Note request = createNote();
        Note entity = createNote();
        ;
        when(repository.save(anyString(), any())).thenReturn(entity);
        when(repository.findById(anyString(), anyLong())).thenReturn(Optional.empty());
        Note note = noteService.updateNote(TEST_USER_NAME, TEST_NOTE_ID, request);
        assertEquals(entity, note);
        verify(repository, times(1)).save(anyString(), any());
        verify(repository, times(1)).findById(anyString(), anyLong());
    }

    @Test
    public void removeNoteSuccess() {
        noteService.removeNote(TEST_USER_NAME, TEST_NOTE_ID);
        verify(repository, times(1)).deleteById(anyString(), anyLong());
    }

    private Note createNote() {
        return Note.builder().id(1L).note("Test").title("TestTitle").build();
    }


}

