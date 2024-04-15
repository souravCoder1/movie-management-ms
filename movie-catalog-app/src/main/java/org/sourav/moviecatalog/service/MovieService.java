package org.sourav.moviecatalog.service;

import org.sourav.moviecatalog.entity.Movie;
import org.sourav.moviecatalog.entity.MovieCatalogItem;
import org.sourav.moviecatalog.entity.Rating;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

// MovieService.java - Service class to handle business logic
@Service
public class MovieService {

    private final WebClient.Builder webClientBuilder;

    @Value("${rating.service.url}")
    private String ratingServiceUrl;

    @Value("${movie.info.service.url}")
    private String movieInfoServiceUrl;

    public MovieService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<MovieCatalogItem> getMoviesForUser(Long userId) {

        // Call rating service to get ratings for the user
        Flux<Rating> ratingsFlux = webClientBuilder.build()
                .get()
                .uri(ratingServiceUrl + "/ratings/{userId}", userId)
                .retrieve()
                .bodyToFlux(Rating.class);

        // Call movie info service to get movie details for each movie in the user's catalog
        return ratingsFlux.flatMap(rating ->
                        webClientBuilder.build()
                                .get()
                                .uri(movieInfoServiceUrl + "/movies/{movieId}", rating.getMovieId())
                                .retrieve()
                                .bodyToMono(Movie.class)
                                .map(movieResponse ->
                                        new MovieCatalogItem(
                                                movieResponse.getId(),
                                                movieResponse.getTitle(),
                                                movieResponse.getGenre(),
                                                rating.getUser(),
                                                rating.getRating())));
    }
}
