package com.uniyaz.note.dao;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.dto.queryfilter.NoteQueryFilterDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

//    @Autowired
//    private EntityManagerFactory entityManagerFactory;

/*  EntityManagerFactory @Autowired ile bağlanırsa ve
 *  EntityManager bu şekilde oluşturulursa, entityManager.close()
 *  metoduyla el ile kapatmak gerekecektir. Kapatılmazsa
 *  bağlantılar açık kalacağı için her queryde yeniden oluşur.
 *  Bu yüzden max bağlantı sayısını aşar ve hataya düşer.
 *
 *  @PersistanceContext EntityManager nesnesini Factory kullanmadan
 *  oluşturur, bu yüzden el ile kapatmaya gerek kalmaz.
 */
    @PersistenceContext
    private EntityManager entityManager;

    public Note findById(Long noteId) {
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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Note> query = criteriaBuilder.createQuery(Note.class);
        Root<Note> root = query.from(Note.class);
        query.select(root);

        TypedQuery<Note> q = entityManager.createQuery(query);
        return q.getResultList();
    }

    public List<Note> findByNoteQueryFilterDto(NoteQueryFilterDto noteQueryFilterDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Note> query = criteriaBuilder.createQuery(Note.class);
        Root<Note> root = query.from(Note.class);
        query.select(root);

        noteQueryFilterDto.addWhereClause(criteriaBuilder, query);
        TypedQuery<Note> q = entityManager.createQuery(query);
        return q.getResultList();
    }
}
