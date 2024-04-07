package org.sourav.moviecatalog.repo;

import org.sourav.moviecatalog.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// MovieRepository.java - Repository interface for Movie entity
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // custom query methods if needed
}