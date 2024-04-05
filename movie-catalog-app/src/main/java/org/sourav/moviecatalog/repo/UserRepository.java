package org.sourav.moviecatalog.repo;

import org.sourav.moviecatalog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// UserRepository.java - Repository interface for User entity
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // custom query methods if needed
}