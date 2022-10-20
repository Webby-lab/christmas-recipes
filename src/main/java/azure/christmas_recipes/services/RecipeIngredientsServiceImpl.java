package azure.christmas_recipes.services;

import azure.christmas_recipes.models.RecipeIngredients;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeIngredientsServiceImpl implements RecipeIngredientsService {
    RecipeIngredientsRepository recipeIngredientsRepository;

    public RecipeIngredientsServiceImpl(RecipeIngredientsRepository recipeIngredientsRepository) {
        this.recipeIngredientsRepository = recipeIngredientsRepository;
    }

    @Override
    public List<RecipeIngredients> findAllByRecipeName(String name) {
        return null;
    }

    @Override
    public List<String> getIngredientsByRecipeName(String name) {
        return recipeIngredientsRepository.findIngredientsByRecipeName(name);
    }

    @Override
    public List<String> getIngredientsByRecipeNameNo(String name) {
        return recipeIngredientsRepository.findIngredientsByRecipeNameNo(name);
    }
}
