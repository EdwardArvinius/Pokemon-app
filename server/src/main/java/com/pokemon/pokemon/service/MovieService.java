
package com.pokemon.pokemon.service;
import com.pokemon.pokemon.model.Movie;
import com.pokemon.pokemon.repository.MovieRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository repo;
    @Autowired
    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public List<Movie> listMovies() {
        return repo.listMovies();
    }

}
