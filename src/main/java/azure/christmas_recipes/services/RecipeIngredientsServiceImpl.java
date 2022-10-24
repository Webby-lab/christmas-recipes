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
    public String getIngredientsFromSelectedRecipies(String nameFirst, String nameOther) {
        HashMap<String, Double> selectedIngredient = new HashMap<>();
        List<String> ingredientsFromFirst = recipeIngredientsRepository.findIngredientsByRecipeNameNo(nameFirst);
        for (String text : ingredientsFromFirst) {
            String[] splitted = text.split(",");
            selectedIngredient.put(splitted[1], Double.parseDouble(splitted[0]));
        }
        List<String> ingredientsFromSecond = recipeIngredientsRepository.findIngredientsByRecipeNameNo(nameOther);
        for (String text : ingredientsFromSecond) {
            String[] splitted1 = text.split(",");
            if (!selectedIngredient.containsKey(splitted1[1]))
                selectedIngredient.put(splitted1[1], Double.parseDouble(splitted1[0]));
            else {
                selectedIngredient.put(splitted1[1], selectedIngredient.get(splitted1[1] + Double.parseDouble(splitted1[0])));
            }
        }
            StringBuilder shoppingList = new StringBuilder();
            for (String key : selectedIngredient.keySet()) {
                shoppingList.append(key + selectedIngredient.get(key) + ", ");
            }
            return shoppingList.toString();
        }
    }
