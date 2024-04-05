package org.sourav.ratingdataapp.controller;

import org.sourav.ratingdataapp.entity.Rating;
import org.sourav.ratingdataapp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// RatingController.java - Controller class to handle HTTP requests
@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    
    @GetMapping("/{userId}")
    public ResponseEntity<List<Rating>> getUserRatings(@PathVariable Long userId) {
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        if (!ratings.isEmpty()) {
            return ResponseEntity.ok(ratings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}