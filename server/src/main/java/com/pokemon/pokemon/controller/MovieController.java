package com.pokemon.pokemon.controller;

import com.pokemon.pokemon.model.Movie;
import com.pokemon.pokemon.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    Logger logger = Logger.getLogger(Movie.class.getName());
    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> body = service.listMovies();
        logger.info(body.toString());
        return ResponseEntity.ok(body);
    }
}