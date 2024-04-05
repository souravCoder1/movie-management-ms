package org.sourav.movieinfodetailsapp.service;

import org.sourav.movieinfodetailsapp.repo.MovieRepository;
import org.sourav.movieinfodetailsapp.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// MovieService.java - Service class to handle business logic
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}