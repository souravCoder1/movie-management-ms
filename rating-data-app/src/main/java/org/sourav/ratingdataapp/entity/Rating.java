package org.sourav.ratingdataapp.entity;

import jakarta.persistence.*;
import org.sourav.ratingdataapp.entity.User;

// Rating.java - Entity class representing a movie rating
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private Long movieId;
    private int rating;
    // other attributes, getters, and setters
}