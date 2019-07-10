package com.uniyaz.note.repository;

import com.uniyaz.note.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
