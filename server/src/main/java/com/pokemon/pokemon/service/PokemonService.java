package com.pokemon.pokemon.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.pokemon.model.FavouritePokemon;
import com.pokemon.pokemon.model.Pokemon;
import com.pokemon.pokemon.repository.FavouritePokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;
    private final FavouritePokemonRepository favouritePokemonRepository;

    @Autowired
    public PokemonService(RestTemplateBuilder restTemplateBuilder, FavouritePokemonRepository favouritePokemonRepository) {
        this.restTemplate = restTemplateBuilder.build();
        this.favouritePokemonRepository = favouritePokemonRepository;
    }

    public FavouritePokemon saveFavouritePokemon(Pokemon pokemon) {
        FavouritePokemon favouritePokemon = new FavouritePokemon();
        favouritePokemon.setName(pokemon.getName());
        favouritePokemon.setAbilities(pokemon.getAbilities());
        favouritePokemon.setStats(pokemon.getStats());
        favouritePokemon.setType(pokemon.getType());
        favouritePokemon.setImage(pokemon.getImage());

        return favouritePokemonRepository.save(favouritePokemon);
    }

    public List<FavouritePokemon> getAllFavouritePokemon() {
        return favouritePokemonRepository.findAll();
    }


    public Pokemon getAPokemon(String name) {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://pokeapi.co/api/v2/pokemon/" + name, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = null;

        try {
            root = objectMapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Pokemon pokemon = new Pokemon();

        pokemon.setName(root.path("name").asText());

        pokemon.setImage(root.path("sprites").path("front_default").asText());

        List<String> abilities = new ArrayList<>();
        root.path("abilities").forEach(a -> {
            abilities.add(a.path("ability").path("name").asText());
        });
        pokemon.setAbilities(abilities);

        Map<String, Integer> stats = new HashMap<>();
        root.path("stats").forEach(s -> {
            stats.put(s.path("stat").path("name").asText(), s.path("base_stat").asInt());
        });
        pokemon.setStats(stats);

        pokemon.setType(root.path("types").path(0).path("type").path("name").asText());

        return pokemon;
    }

    public void deleteFavouritePokemon(Long id) {
        favouritePokemonRepository.deleteById(id);
    }
}

