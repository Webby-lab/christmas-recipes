package azure.christmas_recipes.controllers;

import azure.christmas_recipes.exceptions.EmailAlreadyExistsException;
import azure.christmas_recipes.models.dtos.ErrorDTO;
import azure.christmas_recipes.models.dtos.UserDTO;
import azure.christmas_recipes.models.entities.User;
import azure.christmas_recipes.services.IngredientService;
import azure.christmas_recipes.services.RecipeIngredientsService;
import azure.christmas_recipes.services.RecipeService;
import azure.christmas_recipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class RecipeRestController {
    RecipeIngredientsService recipeIngredientsService;
    IngredientService ingredientService;
    UserService userService;
    RecipeService recipeService;
    @Autowired
    public RecipeRestController(RecipeIngredientsService recipeIngredientsService, IngredientService ingredientService, UserService userService, RecipeService recipeService) {
        this.recipeIngredientsService = recipeIngredientsService;
        this.ingredientService = ingredientService;
        this.userService = userService;
        this.recipeService = recipeService;
    }
    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable Integer id) {
        Optional<UserDTO> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.status(200).body(user.get());
        } else {
            return ResponseEntity.status(404).body(new ErrorDTO("No such user"));
        }
    }
    @PostMapping
    public ResponseEntity register(@RequestBody User user) {
        try {
            UserDTO registeredUser = userService.register(user);
            return ResponseEntity.status(201).body(registeredUser) ;
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(406).body(new ErrorDTO(e.getMessage()));
        } catch (EmailAlreadyExistsException e) {
                return ResponseEntity.status(409).body(new ErrorDTO(e.getMessage()));
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
