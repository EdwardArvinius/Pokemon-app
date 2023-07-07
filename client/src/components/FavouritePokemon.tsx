import React from 'react';
import axios from 'axios';

interface Pokemon {
    id: number;
    name: string;
    abilities: string[];
    stats: Record<string, number>;
    type: string;
    image: string;
}

interface Props {
    favoritePokemons: Pokemon[];
}

const FavouritePokemon: React.FC<Props> = ({ favoritePokemons }) => {

    const deleteFavoritePokemon = async (pokemonId: number) => {
        try {
            await axios.delete(`http://localhost:8080/api/v2/pokemon/favourites/${pokemonId}`);
            // fetchFavoritePokemons();  
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div>
            <h2>Favourite Pokemons:</h2>
            {favoritePokemons.map((pokemon, index) => (
                <div key={index} className='favourite-pokemons'>
                    <h1>{pokemon.name}</h1>
                    <img src={pokemon.image} alt={pokemon.name} />
                    <p>Type: {pokemon.type}</p>
                    <p>Abilities: {pokemon.abilities.join(', ')}</p>
                    <p>Health: {pokemon.stats["hp"]}</p>
                    <p>Attack: {pokemon.stats["attack"]}</p>
                    <p>Defense: {pokemon.stats["defense"]}</p>
                    <p>Speed: {pokemon.stats["speed"]}</p>
                    <button onClick={() => deleteFavoritePokemon(pokemon.id)}>Delete</button>
                </div>
            ))}
        </div>
    );
};

export default FavouritePokemon;
