package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAll();
@Query(nativeQuery = true, value = "SELECT name from recipes")
    List<String> findAllByRecipeName();
}
