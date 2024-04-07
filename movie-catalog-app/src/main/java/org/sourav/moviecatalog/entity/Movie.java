package org.sourav.moviecatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Movie.java - Entity class representing a movie
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Long id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    // other attributes, getters, and setters
}
