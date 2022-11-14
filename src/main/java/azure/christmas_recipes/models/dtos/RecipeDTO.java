package azure.christmas_recipes.models.dtos;

import azure.christmas_recipes.models.entities.Level;
import azure.christmas_recipes.models.entities.Recipe;

public class RecipeDTO {
    private Integer id;
    private String name;
    private Double cookingTime;
    private Level level;

    public RecipeDTO() {
    }

    public RecipeDTO(Recipe recipe) {
        id = recipe.getId();
        name = recipe.getName();
        cookingTime = recipe.getCookingTime();
        level = recipe.getLevel();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Double cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
