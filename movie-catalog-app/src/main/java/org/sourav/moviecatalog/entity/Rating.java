package org.sourav.moviecatalog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Rating.java - Entity class representing a movie rating
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private Long id;
    private User user;
    private Long movieId;
    private int rating;
    // other attributes, getters, and setters
}