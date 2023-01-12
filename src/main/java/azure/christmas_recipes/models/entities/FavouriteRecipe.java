package azure.christmas_recipes.models.entities;

import azure.christmas_recipes.models.dtos.FavouriteRecipeReqDTO;

import javax.persistence.*;

@Entity(name = "favourite_recepies")
public class FavouriteRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String recipeName;
    @ManyToOne
    private User user;
    private boolean isFavourite;

    public FavouriteRecipe() {
    }

    public FavouriteRecipe(User user, FavouriteRecipeReqDTO favouriteRecipeDTO) {
        this.recipeName = favouriteRecipeDTO.getRecipeName();
        this.user = user;
        this.isFavourite = favouriteRecipeDTO.isFavourite();
    }

    public FavouriteRecipe(String recipeName, User user) {
        this.recipeName = recipeName;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
