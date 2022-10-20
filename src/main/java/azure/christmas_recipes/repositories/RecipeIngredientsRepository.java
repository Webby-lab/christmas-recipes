package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.Ingredient;
import azure.christmas_recipes.models.Recipe;
import azure.christmas_recipes.models.RecipeIngredients;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeIngredientsRepository extends CrudRepository<RecipeIngredients, Integer> {

@Query(nativeQuery = true, value ="SELECT CONCAT_WS(' ', amount, unit, ingredients.name) AS ingredients\n" +
        "FROM recipes JOIN recipe_ingredients\n" +
        "ON recipes.id = recipe_ingredients.recipe_id\n" +
        "JOIN ingredients\n" +
        "ON recipe_ingredients.ingredient_name = ingredients.name WHERE recipes.name = :name")
    public List<String> findIngredientsByRecipeName(String name);

@Query(nativeQuery = true, value = "SELECT amount, ingredients.name\n" +
        "    FROM recipes JOIN recipe_ingredients\n" +
        "    ON recipes.id = recipe_ingredients.recipe_id\n" +
        "    JOIN ingredients\n" +
        "    ON recipe_ingredients.ingredient_name = ingredients.name\n" +
        "    WHERE recipes.name = :name")
    public List<String> findIngredientsByRecipeNameNo(String name);

}
