package azure.christmas_recipes.services;

import azure.christmas_recipes.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe getRecipeById(Integer id);
    List<Recipe> findAll();
}
