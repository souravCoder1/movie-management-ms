package org.sourav.ratingdataapp.service;

import org.sourav.ratingdataapp.entity.Rating;
import org.sourav.ratingdataapp.repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// RatingService.java - Service class to handle business logic
@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }
}