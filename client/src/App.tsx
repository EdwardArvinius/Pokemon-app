import { useState } from 'react'
import './App.css'
import PokemonSearch from './components/PokemonSearch';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>

<div className="App">
      <h1>Pokédex</h1>
      <PokemonSearch />
    </div>
    </>
  )
}

export default App
