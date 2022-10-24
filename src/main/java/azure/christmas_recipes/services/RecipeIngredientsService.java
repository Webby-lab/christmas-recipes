package azure.christmas_recipes.services;

import azure.christmas_recipes.models.entities.RecipeIngredients;

import java.util.List;

public interface RecipeIngredientsService {
    List<RecipeIngredients> findAllByRecipeName(String name);
    List<String> getIngredientsByRecipeName(String name);
    List<String> getIngredientsByRecipeNameNo(String name);
    String getIngredientsFromSelectedRecipies(String namefirst, String nameSecond);
}
