package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.FavouriteRecipeReqDTO;
import azure.christmas_recipes.models.dtos.FavouriteRecipeResDTO;
import azure.christmas_recipes.models.entities.FavouriteRecipe;
import azure.christmas_recipes.models.entities.User;
import azure.christmas_recipes.repositories.FavouriteRecipeRepository;
import azure.christmas_recipes.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteRecipeServiceImpl implements FavouriteRecipeService {
    private UserRepository userRepository;
    private FavouriteRecipeRepository favouriteRecipeRepository;

    public FavouriteRecipeServiceImpl(UserRepository userRepository, FavouriteRecipeRepository favouriteRecipeRepository) {
        this.userRepository = userRepository;
        this.favouriteRecipeRepository = favouriteRecipeRepository;
    }

    @Override
    public FavouriteRecipeResDTO save(int userId, FavouriteRecipeReqDTO favouriteRecipeDTO) throws NoSuchUserException {
        Optional<FavouriteRecipe> favouriteRecipeInDb = favouriteRecipeRepository.findByRecipeNameAndUserId(favouriteRecipeDTO.getRecipeName(), userId);
        if (favouriteRecipeInDb.isPresent() && favouriteRecipeInDb.get().isFavourite() == favouriteRecipeDTO.isFavourite()) {
            return new FavouriteRecipeResDTO(favouriteRecipeInDb.get()) ;
        }else if (favouriteRecipeInDb.isPresent()) {
        FavouriteRecipe favouriteRecipe = favouriteRecipeInDb.get();
        favouriteRecipe.setFavourite(favouriteRecipeDTO.isFavourite());
        return new FavouriteRecipeResDTO(favouriteRecipeRepository.save(favouriteRecipe)) ;
        } else {
            User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
            FavouriteRecipe favouriteRecipe = new FavouriteRecipe(user, favouriteRecipeDTO);
            return new FavouriteRecipeResDTO(favouriteRecipeRepository.save(favouriteRecipe)) ;
        }

    }

    @Override
    public int getPopularityOfRecipe(String recipeName) {

        return favouriteRecipeRepository.countByRecipeNameAndIsFavourite(recipeName, true );
    }


}
