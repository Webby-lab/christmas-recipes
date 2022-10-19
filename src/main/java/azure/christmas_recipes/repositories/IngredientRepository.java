package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
}
