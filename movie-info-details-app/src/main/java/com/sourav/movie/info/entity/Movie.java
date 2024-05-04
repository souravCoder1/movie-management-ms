package com.sourav.movie.info.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Movie.java - Entity class representing a movie
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Ensure this is present
    private Long id;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    // other attributes, getters, and setters
}
