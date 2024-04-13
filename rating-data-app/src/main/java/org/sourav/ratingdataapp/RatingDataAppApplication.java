package org.sourav.ratingdataapp;

import org.sourav.ratingdataapp.entity.Rating;
import org.sourav.ratingdataapp.entity.User;
import org.sourav.ratingdataapp.repo.RatingRepository;
import org.sourav.ratingdataapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RatingDataAppApplication implements CommandLineRunner {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RatingDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create a User instance
		User user = new User();
		user.setId(1L); // Set the user ID
		user.setName("John Doe"); // Set the user name

		// Save the User entity
		userRepository.save(user);

		// Create a Rating instance
		Rating rating = new Rating();
		rating.setRating(5); // Set the rating
		rating.setUser(user); // Set the user (many-to-one relationship)
		rating.setMovieId(123L); // Set the movie ID or any other attributes

		// Now persist the Rating entity using Spring Data JPA repository
		ratingRepository.saveAndFlush(rating);
	}

}
