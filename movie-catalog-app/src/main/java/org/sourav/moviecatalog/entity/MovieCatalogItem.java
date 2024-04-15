package org.sourav.moviecatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Movie.java - Entity class representing a movie
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCatalogItem  {
    private Long movieId;
    private String title;
    private String genre;
    private User user;
    private int rating;
    // other attributes, getters, and setters
}