package org.sourav.moviecatalog.service;

import org.sourav.moviecatalog.entity.Movie;
import org.sourav.moviecatalog.entity.MovieCatalogItem;
import org.sourav.moviecatalog.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

// MovieService.java - Service class to handle business logic
@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rating.service.url}")
    private String ratingServiceUrl;

    @Value("${movie.info.service.url}")
    private String movieInfoServiceUrl;

    public List<MovieCatalogItem> getMoviesForUser(Long userId) {

        // Call rating service to get ratings for the user
        List<Rating> ratings = restTemplate.exchange(
                ratingServiceUrl + "/ratings/{userId}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Rating>>() {
                },
                userId
        ).getBody();


        // Call movie info service to get movie details for each movie in the user's catalog
        return ratings.stream()
                .map(rating -> {
                    Movie movieResponse = restTemplate.exchange(
                            movieInfoServiceUrl + "/movies/{movieId}",
                            HttpMethod.GET,
                            null,
                            Movie.class,
                            rating.getMovieId()
                    ).getBody();


                    return new MovieCatalogItem(
                            movieResponse.getId(),
                            movieResponse.getTitle(),
                            movieResponse.getGenre(),
                            rating.getUser(),
                            rating.getRating());
                })
                .collect(Collectors.toList());
    }
}