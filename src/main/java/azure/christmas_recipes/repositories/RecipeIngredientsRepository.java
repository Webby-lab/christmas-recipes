package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.RecipeIngredients;
import org.springframework.data.repository.CrudRepository;

public interface RecipeIngredientsRepository extends CrudRepository<RecipeIngredients, Integer> {
}
