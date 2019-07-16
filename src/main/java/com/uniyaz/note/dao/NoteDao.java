package com.uniyaz.note.dao;

import com.uniyaz.note.domain.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
}
