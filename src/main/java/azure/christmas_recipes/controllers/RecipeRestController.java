package azure.christmas_recipes.controllers;

import azure.christmas_recipes.repositories.IngredientRepository;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import azure.christmas_recipes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeRestController {
    RecipeIngredientsRepository recipeIngredientsRepository;
    IngredientRepository ingredientRepository;
    RecipeRepository recipeRepository;
    @Autowired
    public RecipeRestController(RecipeIngredientsRepository recipeIngredientsRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.recipeIngredientsRepository = recipeIngredientsRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }
}
