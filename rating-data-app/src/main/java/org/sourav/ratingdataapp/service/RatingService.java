package org.sourav.ratingdataapp.service;

import org.sourav.ratingdataapp.entity.Rating;
import org.sourav.ratingdataapp.entity.User;
import org.sourav.ratingdataapp.repo.RatingRepository;
import org.sourav.ratingdataapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// RatingService.java - Service class to handle business logic
@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }
}