package org.sourav.moviecatalog.service;

import org.sourav.moviecatalog.entity.Movie;
import org.sourav.moviecatalog.entity.MovieCatalogItem;
import org.sourav.moviecatalog.entity.Rating;
import org.sourav.moviecatalog.config.MovieInfoFeignClient;
import org.sourav.moviecatalog.config.RatingFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final RatingFeignClient ratingServiceClient;
    private final MovieInfoFeignClient movieInfoServiceClient;

    @Value("${rating.service.url}")
    private String ratingServiceUrl;

    @Value("${movie.info.service.url}")
    private String movieInfoServiceUrl;

    @Autowired
    public MovieService(RatingFeignClient ratingServiceClient, MovieInfoFeignClient movieInfoServiceClient) {
        this.ratingServiceClient = ratingServiceClient;
        this.movieInfoServiceClient = movieInfoServiceClient;
    }

    public List<MovieCatalogItem> getMoviesForUser(Long userId) {
        // Call rating service to get ratings for the user
        List<Rating> ratings = ratingServiceClient.getRatingsForUser(userId);

        // Call movie info service to get movie details for each movie in the user's catalog
        return ratings.stream()
                .map(rating -> {
                    Movie movieResponse = movieInfoServiceClient.getMovieInfo(rating.getMovieId());
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
