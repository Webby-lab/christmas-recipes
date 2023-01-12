package azure.christmas_recipes.models.dtos;

import azure.christmas_recipes.models.entities.FavouriteRecipe;
import azure.christmas_recipes.models.entities.User;



public class FavouriteRecipeResDTO {

    private Integer id;
    private String recipeName;
    private Integer userId;
    private boolean isFavourite;


    public FavouriteRecipeResDTO() {
    }

    public FavouriteRecipeResDTO(FavouriteRecipe favouriteRecipe) {
        this.id = favouriteRecipe.getId();
        this.recipeName = favouriteRecipe.getRecipeName();
        this.userId = favouriteRecipe.getUser().getId();
        this.isFavourite = favouriteRecipe.isFavourite();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
