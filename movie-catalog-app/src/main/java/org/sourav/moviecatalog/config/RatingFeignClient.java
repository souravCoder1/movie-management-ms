package org.sourav.moviecatalog.config;

import org.sourav.moviecatalog.entity.Movie;
import org.sourav.moviecatalog.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rating-data-app", url = "${rating.service.url}")
public interface RatingFeignClient {

    @GetMapping("/ratings/{userId}")
    List<Rating> getRatingsForUser(@PathVariable("userId") Long userId);
}

