package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
