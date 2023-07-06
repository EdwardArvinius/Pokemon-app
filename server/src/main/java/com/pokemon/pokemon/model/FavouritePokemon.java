package com.pokemon.pokemon.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "favourite_pokemons")
public class FavouritePokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    @ElementCollection
    private List<String> abilities;

    @ElementCollection
    @MapKeyColumn(name="stat_name")
    @Column(name="value")
    private Map<String, Integer> stats;

    private String type;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
