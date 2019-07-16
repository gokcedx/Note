package com.uniyaz.note.service;

import com.uniyaz.note.dao.NoteDao;
import com.uniyaz.note.domain.Note;
import com.uniyaz.note.domain.User;
import com.uniyaz.note.dto.NoteDto;
import com.uniyaz.note.repository.NoteRepository;
import com.uniyaz.note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author Kübra VARICI
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NoteService {

    @Autowired
    NoteDao noteDao;

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserRepository userRepository;

    public Note saveNote(NoteDto noteDto){
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setKonu(noteDto.getKonu());
        note.setIcerik(noteDto.getIcerik());
        note.setKayitTarihi(DateService.getTodayDate());
        note.setBegenilmeSayisi(noteDto.getBegenilmeSayisi());

        if (noteDto.getUserId() != null){
            Optional<User> userById = userRepository.findById(noteDto.getUserId());
            note.setUser(userById.get());
        }

        return noteRepository.save(note);
    }

    public Note findById(Long noteId) {
        noteDao.findById(noteId);
        return noteDao.findById(noteId);
    }
}
