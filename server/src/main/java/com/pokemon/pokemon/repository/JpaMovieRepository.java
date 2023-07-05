package com.pokemon.pokemon.repository;

import com.pokemon.pokemon.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMovieRepository extends JpaRepository<Movie, Long> {
}