package com.uniyaz.note.dao;

import com.uniyaz.note.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@Repository
public class UserDao {

//    @Autowired
//    EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(Long userId){
        String hql = "Select user " +
                     "From User user " +
                     "Where user.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", userId);
        return (User) query.getSingleResult();
    }
}
