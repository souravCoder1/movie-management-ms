package org.sourav.ratingdataapp.entity;

import jakarta.persistence.*;
import lombok.Data;

// User.java - Entity class representing a user
@Entity
@Table(name = "usr")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // Ensure this is present
    private Long id;
    private String name;
    // other attributes, getters, and setters
}