package com.sourav.movie.info.repo;

import com.sourav.movie.info.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// MovieRepository.java - Repository interface for Movie entity
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // custom query methods if needed
}