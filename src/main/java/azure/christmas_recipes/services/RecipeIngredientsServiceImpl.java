package azure.christmas_recipes.services;

import azure.christmas_recipes.models.entities.RecipeIngredients;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

        @Override
        public String getIngredientsListByRecipeName(List<String> favouriteRecipies) {
        HashMap<String, Double> shoppingListItems = new HashMap<>();
           for (String recipeName : favouriteRecipies) {
               List<String> ingredientsFromRecipeByName = recipeIngredientsRepository.findIngredientsByRecipeNameNo(recipeName);
               for (String text : ingredientsFromRecipeByName) {
                   String[] splitted = text.split(",");
                   if (!shoppingListItems.containsKey(splitted[1])) {
                       shoppingListItems.put(splitted[1], Double.parseDouble(splitted[0]) );
                   } else {
                       shoppingListItems.put(splitted[1], shoppingListItems.get(splitted[1]) + Double.parseDouble(splitted[0]) );
                   }
                }
           }
        StringBuilder shoppingList = new StringBuilder();
        for (String key : shoppingListItems.keySet()) {
            shoppingList.append(key + ", " + shoppingListItems.get(key));
        }
        return shoppingList.toString();
        }





    }
