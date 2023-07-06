package com.pokemon.pokemon.controller;





import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class PokemonController {

    private final RestTemplate restTemplate;

    @Autowired
    public PokemonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<String> getPokemonInfo(@PathVariable String name) {
        return null;
    }
}
