import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import PokemonInfo from './components/PokemonInfo';

function App() {
  const [count, setCount] = useState(0)

  return (
    <>

<div className="App">
      <h1>Pokemon Information</h1>
      <PokemonInfo />
    </div>
    </>
  )
}

export default App
