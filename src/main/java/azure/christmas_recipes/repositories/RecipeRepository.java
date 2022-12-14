package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAll();

}
