package azure.christmas_recipes.services;

import azure.christmas_recipes.models.dtos.RecipesDTO;
import azure.christmas_recipes.models.dtos.UserRegistrationDTO;
import azure.christmas_recipes.models.entities.Recipe;
import azure.christmas_recipes.models.entities.User;

import java.util.List;

public interface RecipeService {
    Recipe getRecipeById(Integer id);
    List<Recipe> findAll();
    RecipesDTO findUserRecipies(int userId);
}
