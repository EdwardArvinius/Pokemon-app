package repositoryTest;

import com.pokemon.pokemon.model.FavouritePokemon;
import com.pokemon.pokemon.repository.FavouritePokemonRepository;
import com.pokemon.pokemon.repository.JpaFavouritePokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FavouritePokemonRepositoryTest {

    @Mock
    private JpaFavouritePokemonRepository jpaFavouritePokemonRepository;

    @InjectMocks
    private FavouritePokemonRepository favouritePokemonRepository;

    private FavouritePokemon testFavouritePokemon;



}
