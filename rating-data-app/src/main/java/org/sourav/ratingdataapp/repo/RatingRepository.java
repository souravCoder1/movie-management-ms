package org.sourav.ratingdataapp.repo;

import org.sourav.ratingdataapp.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// RatingRepository.java - Repository interface for Rating entity
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long userId);
}
