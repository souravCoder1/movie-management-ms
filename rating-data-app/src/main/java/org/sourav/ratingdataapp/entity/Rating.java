package org.sourav.ratingdataapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.sourav.ratingdataapp.entity.User;

// Rating.java - Entity class representing a movie rating
@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    private Long movieId;
    private int rating;
    // other attributes, getters, and setters
}