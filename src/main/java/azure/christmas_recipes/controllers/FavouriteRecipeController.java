package azure.christmas_recipes.controllers;

import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.ErrorDTO;
import azure.christmas_recipes.models.dtos.FavouriteRecipeReqDTO;
import azure.christmas_recipes.models.dtos.FavouriteRecipeResDTO;
import azure.christmas_recipes.models.entities.FavouriteRecipe;
import azure.christmas_recipes.services.FavouriteRecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favourite-recipe")
public class FavouriteRecipeController {

    private FavouriteRecipeService favouriteRecipeService;

    public FavouriteRecipeController(FavouriteRecipeService favouriteRecipeService) {
        this.favouriteRecipeService = favouriteRecipeService;
    }
    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity handleNoSuchUser(NoSuchUserException e) {
        return ResponseEntity.status(404).body(new ErrorDTO(e.getMessage()));
    }

    @PostMapping
    public ResponseEntity favouriteRecipe(
            @RequestHeader(value = "Authorization") Integer userId,
            @RequestBody FavouriteRecipeReqDTO favouriteRecipe
            ) {
        FavouriteRecipeResDTO newFavouriteRecipe = favouriteRecipeService.save(userId, favouriteRecipe);
        return ResponseEntity.status(201).body(newFavouriteRecipe);
    }

}
