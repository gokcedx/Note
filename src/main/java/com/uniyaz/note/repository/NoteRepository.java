package com.uniyaz.note.repository;

import com.uniyaz.note.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kübra VARICI
 */

public interface NoteRepository extends JpaRepository<Note, Long>{
}
