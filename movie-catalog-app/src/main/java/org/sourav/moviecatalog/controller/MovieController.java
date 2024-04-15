package org.sourav.moviecatalog.controller;

import org.sourav.moviecatalog.entity.MovieCatalogItem;
import org.sourav.moviecatalog.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

// MovieController.java - Controller class to handle HTTP requests
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/{userId}")
    public ResponseEntity<Flux<MovieCatalogItem>> getUserMovies(@PathVariable Long userId) {
        Flux<MovieCatalogItem> movies = movieService.getMoviesForUser(userId);
        if (movies != null) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}