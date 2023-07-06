package com.pokemon.pokemon.repository;

import com.pokemon.pokemon.model.FavouritePokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFavouritePokemonRepository extends JpaRepository<FavouritePokemon, Long> {
}
