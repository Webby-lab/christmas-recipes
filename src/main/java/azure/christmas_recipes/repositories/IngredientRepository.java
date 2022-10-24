package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.entities.Ingredient;
import azure.christmas_recipes.models.entities.Unit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();
    @Query(nativeQuery = true, value = "SELECT unit FROM christmas.ingredients where name = :name")
    public List<Unit> findAllUnitByIngredientsName(String name);
}
