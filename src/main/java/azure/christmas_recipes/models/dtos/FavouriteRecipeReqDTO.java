package azure.christmas_recipes.models.dtos;

import azure.christmas_recipes.models.entities.FavouriteRecipe;

public class FavouriteRecipeReqDTO {
    private String recipeName;
    private boolean isFavourite = true;




    public FavouriteRecipeReqDTO() {
    }


    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
