package com.pokemon.pokemon.controller;


import com.pokemon.pokemon.model.FavouritePokemon;
import com.pokemon.pokemon.model.Pokemon;
import com.pokemon.pokemon.repository.FavouritePokemonRepository;
import com.pokemon.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("/api/v2/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    private final FavouritePokemonRepository favouritePokemonRepository;
    @Autowired
    public PokemonController(PokemonService pokemonService, FavouritePokemonRepository favouritePokemonRepository) {
        this.pokemonService = pokemonService;
        this.favouritePokemonRepository = favouritePokemonRepository;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable String name) {
        return new ResponseEntity<>(pokemonService.getAPokemon(name), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/favourites/{name}")
    public ResponseEntity<FavouritePokemon> addFavouritePokemon(@PathVariable String name) {
        Pokemon pokemon = pokemonService.getAPokemon(name);
        FavouritePokemon favouritePokemon = pokemonService.saveFavouritePokemon(pokemon);
        return new ResponseEntity<>(favouritePokemon, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/favourites")
    public ResponseEntity<List<FavouritePokemon>> getFavouritePokemons() {
        List<FavouritePokemon> favouritePokemons = favouritePokemonRepository.findAll();
        return new ResponseEntity<>(favouritePokemons, HttpStatus.OK);
    }

    @DeleteMapping("/favourites/{id}")
    public ResponseEntity<Void> deleteFavouritePokemon(@PathVariable Long id) {
        pokemonService.deleteFavouritePokemon(id);
        return ResponseEntity.ok().build();
    }
}
