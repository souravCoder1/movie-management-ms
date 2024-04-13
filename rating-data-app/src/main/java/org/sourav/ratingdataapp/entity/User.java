package org.sourav.ratingdataapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// User.java - Entity class representing a user
@Entity
@Table(name = "usr")
@Data
public class User {
    @Id
    private Long id;
    private String name;
    // other attributes, getters, and setters
}