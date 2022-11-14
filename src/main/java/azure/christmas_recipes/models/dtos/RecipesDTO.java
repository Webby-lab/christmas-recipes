package azure.christmas_recipes.models.dtos;

import azure.christmas_recipes.models.entities.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipesDTO {
    private Integer userId;
    private List<RecipeDTO> recipies = new ArrayList<>();
    private int count;

    public RecipesDTO() {
    }

    public RecipesDTO(Integer userId, List<Recipe> recipies) {
        this.userId = userId;
        this.recipies = recipies.stream().map(RecipeDTO::new).collect(Collectors.toList());
        this.count = recipies.size();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<RecipeDTO> getRecipies() {
        return recipies;
    }

    public void setRecipies(List<RecipeDTO> recipies) {
        this.recipies = recipies;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
