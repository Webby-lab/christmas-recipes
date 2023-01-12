package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.FavouriteRecipeReqDTO;
import azure.christmas_recipes.models.dtos.FavouriteRecipeResDTO;
import azure.christmas_recipes.models.entities.FavouriteRecipe;

public interface FavouriteRecipeService {
    FavouriteRecipeResDTO save(int userId, FavouriteRecipeReqDTO favouriteRecipe) throws NoSuchUserException;

    int getPopularityOfRecipe(String name);
}
