package com.pokemon.pokemon.repository;

import com.pokemon.pokemon.model.FavouritePokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavouritePokemonRepository {

    private final JpaFavouritePokemonRepository jpaFavouritePokemonRepository;

    @Autowired
    public FavouritePokemonRepository(JpaFavouritePokemonRepository jpaFavouritePokemonRepository) {
        this.jpaFavouritePokemonRepository = jpaFavouritePokemonRepository;
    }

    public FavouritePokemon save(FavouritePokemon favouritePokemon) {
        return jpaFavouritePokemonRepository.save(favouritePokemon);
    }

    public List<FavouritePokemon> findAll() {
        return jpaFavouritePokemonRepository.findAll();
    }

}
