package com.uniyaz.note.converter;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.domain.User;
import com.uniyaz.note.dto.NoteDto;
import com.uniyaz.note.service.DateService;
import com.uniyaz.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kübra VARICI
 */
@Component
public class NoteConverter {
    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    public Note convertToNote(NoteDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setKonu(noteDto.getKonu());
        note.setIcerik(noteDto.getIcerik());
        note.setKayitTarihi(DateService.getTodayDate());
        note.setBegenilmeSayisi(noteDto.getBegenilmeSayisi());

        if (noteDto.getUserId() != null) {
            User user = userService.findById(noteDto.getUserId());
            note.setUser(user);
        }
        return note;
    }

    public NoteDto convertToNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setKonu(note.getKonu());
        noteDto.setIcerik(note.getIcerik());
        noteDto.setKayitTarihi(note.getKayitTarihi());
        noteDto.setBegenilmeSayisi(note.getBegenilmeSayisi());
        if (note.getUser() != null){
            noteDto.setUserId(note.getUser().getId());
        }
        return noteDto;
    }

    public List<NoteDto> convertToNoteDtoList(List<Note> noteList){
        List<NoteDto> noteDtoList = new ArrayList<>();
        for (Note note : noteList) {
            NoteDto noteDto = convertToNoteDto(note);
            noteDtoList.add(noteDto);
        }
        return noteDtoList;
    }

}
