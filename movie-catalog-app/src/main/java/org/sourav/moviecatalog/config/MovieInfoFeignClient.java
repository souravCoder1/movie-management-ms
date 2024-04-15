package org.sourav.moviecatalog.config;

import org.sourav.moviecatalog.entity.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-info-details-app", url = "${movie.info.service.url}")
public interface MovieInfoFeignClient {

    @GetMapping("/movies/{movieId}")
    Movie getMovieInfo(@PathVariable("movieId") Long movieId);
}
