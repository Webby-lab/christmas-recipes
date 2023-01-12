package azure.christmas_recipes.models.dtos;

import azure.christmas_recipes.models.entities.Recipe;
import azure.christmas_recipes.services.RecipeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipesDTO {
    private Integer userId;
    private List<RecipeDTO> recipes = new ArrayList<>();
    private int count;

    public RecipesDTO() {
    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
