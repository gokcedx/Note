package com.uniyaz.note.service.rest;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.dto.NoteDto;
import com.uniyaz.note.dto.queryfilter.NoteQueryFilterDto;
import com.uniyaz.note.repository.NoteRepository;
import com.uniyaz.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kübra VARICI
 */

@RestController
@RequestMapping(value="/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
    public Note saveNot(@RequestBody NoteDto noteDto){
        return noteService.saveNote(noteDto);
    }

    @GetMapping("/findAll")
    public List<NoteDto> findNotlar(){
        return noteService.findAll();
    }

    @GetMapping("/findById/{id}")
    public NoteDto findNotById(@PathVariable Long id){
        return noteService.findNoteDtoById(id);
    }

    @GetMapping("/find")
    public List<NoteDto> find(NoteDto noteDto){
        NoteQueryFilterDto noteQueryFilterDto = new NoteQueryFilterDto();
        noteQueryFilterDto.setId(noteDto.getId());
        noteQueryFilterDto.setKonu(noteDto.getKonu());
        noteQueryFilterDto.setIcerik(noteDto.getIcerik());
        noteQueryFilterDto.setKayitTarihi(noteDto.getKayitTarihi());
        noteQueryFilterDto.setBegenilmeSayisi(noteDto.getBegenilmeSayisi());
        noteQueryFilterDto.setUserId(noteDto.getUserId());

        return noteService.findByNoteQueryFilterDto(noteQueryFilterDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNotById(@PathVariable Long id){
        noteRepository.deleteById(id);
    }
}
