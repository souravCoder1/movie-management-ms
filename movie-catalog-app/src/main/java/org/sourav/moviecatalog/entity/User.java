package org.sourav.moviecatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// User.java - Entity class representing a user
public class User {
    @Id
    private Long id;
    private String name;
    // other attributes, getters, and setters
}