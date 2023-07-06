import React, { useState } from 'react';

interface Pokemon {
  name: string;
  abilities: { ability: { name: string } }[];
  types: { type: { name: string } }[];
  health: number;
  attack: number;
  defense: number;
  speed: number;
}

function PokemonInfo() {
  const [pokemon, setPokemon] = useState<Pokemon | null>(null);
  const [pokemonName, setPokemonName] = useState('');

  const fetchPokemon = async () => {
    try {
      const response = await fetch(`/api/pokemon/${pokemonName}`);
      const data = await response.json();
      setPokemon(data);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
     
    </div>
  );
}

export default PokemonInfo;
