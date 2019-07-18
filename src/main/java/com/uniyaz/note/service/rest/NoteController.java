package com.uniyaz.note.service.rest;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.dto.NoteDto;
import com.uniyaz.note.repository.NoteRepository;
import com.uniyaz.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kübra VARICI
 */

@RestController
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @PostMapping("/note")
    public Note saveNot(@RequestBody NoteDto noteDto){
        return noteService.saveNote(noteDto);
    }

    @GetMapping("/note")
    public List<Note> findNotlar(){
        return noteRepository.findAll();
    }

    @GetMapping("/note/{id}")
    public NoteDto findNotById(@PathVariable Long id){
        return noteService.findNoteDtoById(id);
    }

    @DeleteMapping("/note/{id}")
    public void deleteNotById(@PathVariable Long id){
        noteRepository.deleteById(id);
    }
}
