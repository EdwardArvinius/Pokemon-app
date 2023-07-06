import React, { useState } from 'react';
import axios from 'axios';


interface Pokemon {
name: string;
abilities: string[];
stats: Record<string, number>;
type: string;
image: string;
}

const PokemonSearch: React.FC = () => {
    const [pokemonName, setPokemonName] = useState<string>('');
    const [pokemonData, setPokemonData] = useState<Pokemon | null>(null);
    const [isLoading, setIsLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);
    
    
    const searchPokemon = async () => {
    setIsLoading(true);
    setError(null);
    try {
    const res = await axios.get<Pokemon>(`http://localhost:8080/api/v2/pokemon/${pokemonName}`);
    setPokemonData(res.data);
    } catch (err) {
    setError(err.message);
    }
    setIsLoading(false);
    };
    
    
    return (
    <div>
    
    </div>
    );
    };
    
    
    export default PokemonSearch;
    


