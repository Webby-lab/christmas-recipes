package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.entities.FavouriteRecipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FavouriteRecipeRepository extends CrudRepository<FavouriteRecipe, Integer> {
  Optional<FavouriteRecipe> findByRecipeNameAndUserId(String recipeName, int userId);

  int countByRecipeNameAndIsFavourite(String recipeName, boolean isFavourite);
}
