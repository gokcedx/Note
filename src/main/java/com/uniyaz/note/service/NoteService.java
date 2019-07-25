package com.uniyaz.note.service;

import com.uniyaz.note.converter.NoteConverter;
import com.uniyaz.note.dao.NoteDao;
import com.uniyaz.note.domain.Note;
import com.uniyaz.note.dto.NoteDto;
import com.uniyaz.note.dto.queryfilter.NoteQueryFilterDto;
import com.uniyaz.note.repository.NoteRepository;
import com.uniyaz.note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
    NoteConverter noteConverter;

    @Autowired
    UserRepository userRepository;

    public Note saveNote(NoteDto noteDto){
        Note note = noteConverter.convertToNote(noteDto);
        return noteRepository.save(note);
    }

    public NoteDto findNoteDtoById(Long noteId) {
        Note note = noteDao.findById(noteId);
        return noteConverter.convertToNoteDto(note);
    }

    public Note findById(Long noteId) {
        Note note = noteDao.findById(noteId);
        return note;
    }

    public List<NoteDto> findAll() {
        List<Note> noteList = noteDao.findAll();
        return noteConverter.convertToNoteDtoList(noteList);
    }

    public List<NoteDto> findByNoteQueryFilterDto(NoteQueryFilterDto noteQueryFilterDto){
        List<Note> noteList = noteDao.findByNoteQueryFilterDto(noteQueryFilterDto);
        return noteConverter.convertToNoteDtoList(noteList);
    }
}
