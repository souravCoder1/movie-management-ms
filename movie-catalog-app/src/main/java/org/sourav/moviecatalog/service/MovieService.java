package org.sourav.moviecatalog.service;

import org.sourav.moviecatalog.entity.Movie;
import org.sourav.moviecatalog.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// MovieService.java - Service class to handle business logic
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> getMoviesForUser(Long userId) {
        // Implement logic to fetch movies for the given user
        // Example: return movieRepository.findAll();
    }
}