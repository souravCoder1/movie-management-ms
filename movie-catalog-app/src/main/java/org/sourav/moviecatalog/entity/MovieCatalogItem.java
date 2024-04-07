package org.sourav.moviecatalog.entity;

import jakarta.persistence.Entity;
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
public class MovieCatalogItem  {
    @Id
    private Long movieId;
    private String title;
    private String genre;
    private int rating;
    // other attributes, getters, and setters
}