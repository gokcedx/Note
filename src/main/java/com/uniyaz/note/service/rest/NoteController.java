package com.uniyaz.note.service.rest;

import com.uniyaz.note.repository.NoteRepository;
import com.uniyaz.note.domain.Note;
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

    @PostMapping("/note/")
    public Note saveNot(@RequestBody Note note){
        return noteRepository.save(note);
    }

    @GetMapping("/note/")
    public List<Note> findNotlar(){
        return noteRepository.findAll();
    }

    @GetMapping("/note/{id}")
    public Note findNotById(@PathVariable Long id){
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulunamadı!"));
    }

    @DeleteMapping("/note/{id}")
    public void deleteNotById(@PathVariable Long id){
        noteRepository.deleteById(id);
    }
}
