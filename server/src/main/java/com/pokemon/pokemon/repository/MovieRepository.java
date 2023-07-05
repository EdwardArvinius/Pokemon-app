package com.pokemon.pokemon.repository;

import com.pokemon.pokemon.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    JpaMovieRepository repo;
    @Autowired
    public MovieRepository(JpaMovieRepository repo) {
        this.repo = repo;
    }

    public List<Movie> listMovies() {
        return repo.findAll();
    }
}