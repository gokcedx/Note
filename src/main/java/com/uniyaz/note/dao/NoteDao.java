package com.uniyaz.note.dao;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.dto.queryfilter.NoteQueryFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Kübra VARICI
 */
@Repository
public class NoteDao{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public Note findById(Long noteId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String hql =
                "Select note " +
                "From Note note " +
                //"Left Join Fetch note.user user " +
                "Where note.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", noteId);
        return (Note) query.getSingleResult();
    }

    public List<Note> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Note> query = criteriaBuilder.createQuery(Note.class);
        Root<Note> root = query.from(Note.class);
        query.select(root);

        TypedQuery<Note> q = entityManager.createQuery(query);
        return q.getResultList();
    }

    public List<Note> findByNoteQueryFilterDto(NoteQueryFilterDto noteQueryFilterDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Note> query = criteriaBuilder.createQuery(Note.class);
        Root<Note> root = query.from(Note.class);
        query.select(root);

        noteQueryFilterDto.addWhereClause(criteriaBuilder, query);
        TypedQuery<Note> q = entityManager.createQuery(query);
        return q.getResultList();
    }
}
