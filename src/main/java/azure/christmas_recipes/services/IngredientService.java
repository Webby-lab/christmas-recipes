package azure.christmas_recipes.services;

import azure.christmas_recipes.models.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAll();
}
