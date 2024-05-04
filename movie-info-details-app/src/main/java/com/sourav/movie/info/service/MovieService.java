package com.sourav.movie.info.service;

import com.sourav.movie.info.entity.Movie;
import com.sourav.movie.info.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MovieService.java - Service class to handle business logic
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Not found"));
    }

    public Movie saveRating(Movie movie) {
        return movieRepository.save(movie);
    }
}
