package com.uniyaz.note.dao;

import com.uniyaz.note.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@Repository
public class UserDao {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public User findById(Long userId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String hql = "Select user " +
                     "From User user " +
                     "Where user.id = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", userId);
        return (User) query.getSingleResult();
    }
}
