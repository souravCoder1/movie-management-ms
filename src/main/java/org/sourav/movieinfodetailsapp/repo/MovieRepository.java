package org.sourav.movieinfodetailsapp.repo;

import org.sourav.movieinfodetailsapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// MovieRepository.java - Repository interface for Movie entity
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // custom query methods if needed
}