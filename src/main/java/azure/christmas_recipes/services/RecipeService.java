package azure.christmas_recipes.services;

import azure.christmas_recipes.models.entities.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe getRecipeById(Integer id);
    List<Recipe> findAll();
}
