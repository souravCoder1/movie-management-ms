package com.sourav.movie.info.controller;

import com.sourav.movie.info.entity.Movie;
import com.sourav.movie.info.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// MovieController.java - Controller class to handle HTTP requests
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> saveDetails(@RequestBody Movie movie) {
        Movie savedRating = movieService.saveRating(movie);
        return ResponseEntity.ok(savedRating);    }
}