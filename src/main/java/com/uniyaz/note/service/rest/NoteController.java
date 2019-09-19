package com.uniyaz.note.service.rest;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.dto.NoteDto;
import com.uniyaz.note.dto.queryfilter.NoteQueryFilterDto;
import com.uniyaz.note.repository.NoteRepository;
import com.uniyaz.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kübra VARICI
 */
//@Controller
//@ResponseBody
@RestController //Controller + ResponseBody
@RequestMapping(value="/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @PostMapping("/save")
//    @RequestMapping(value="/note", method = RequestMethod.POST)
    public Note saveNot(@RequestBody NoteDto noteDto){
//        noteRepository.save();
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

    @PostMapping(value = "/find", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<NoteDto> find(@RequestBody NoteDto noteDto){
        NoteQueryFilterDto noteQueryFilterDto = new NoteQueryFilterDto();
        noteQueryFilterDto.setId(noteDto.getId());
        noteQueryFilterDto.setKonu(noteDto.getKonu());
        noteQueryFilterDto.setIcerik(noteDto.getIcerik());
        noteQueryFilterDto.setKayitTarihi(noteDto.getKayitTarihi());
        noteQueryFilterDto.setBegenilmeSayisi(noteDto.getBegenilmeSayisi());
        noteQueryFilterDto.setUserId(noteDto.getUserId());

        List<NoteDto> byNoteQueryFilterDto = noteService.findByNoteQueryFilterDto(noteQueryFilterDto);
        return byNoteQueryFilterDto;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNotById(@PathVariable Long id){
        noteRepository.deleteById(id);
    }
}
