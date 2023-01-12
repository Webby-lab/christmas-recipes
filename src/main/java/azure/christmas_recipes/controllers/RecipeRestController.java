package azure.christmas_recipes.controllers;

import azure.christmas_recipes.exceptions.EmailAlreadyExistsException;
import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.ErrorDTO;
import azure.christmas_recipes.models.dtos.RecipesDTO;
import azure.christmas_recipes.models.dtos.UserDTO;
import azure.christmas_recipes.models.dtos.UserRegistrationDTO;
import azure.christmas_recipes.models.entities.User;
import azure.christmas_recipes.repositories.UserRepository;
import azure.christmas_recipes.services.IngredientService;
import azure.christmas_recipes.services.RecipeIngredientsService;
import azure.christmas_recipes.services.RecipeService;
import azure.christmas_recipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class RecipeRestController {

    private RecipeIngredientsService recipeIngredientsService;
    private IngredientService ingredientService;
    private UserService userService;
    private RecipeService recipeService;
    @Autowired
    public RecipeRestController(RecipeIngredientsService recipeIngredientsService, IngredientService ingredientService, UserService userService, RecipeService recipeService) {
        this.recipeIngredientsService = recipeIngredientsService;
        this.ingredientService = ingredientService;
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @ExceptionHandler(NoSuchUserException.class)
        public ResponseEntity handleNoSuchUser(NoSuchUserException e) {
        return ResponseEntity.status(404).body(new ErrorDTO(e.getMessage()));
    }

//    @GetMapping
//    public ResponseEntity ownProfile(@RequestHeader(value = "Authorization") Integer id) {
//        Optional<UserDTO> user = userService.findById(id);
//        return ResponseEntity.status(200).body(user.get());
//    }

    @GetMapping
    public ResponseEntity getRecipesOfUser(@RequestHeader(value = "Authorization") Integer id) {
        RecipesDTO userRecipes = recipeService.findUserRecipes(id);
        return ResponseEntity.ok(userRecipes);

}
    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable Integer id) {
            Optional<UserDTO> user = userService.findById(id);
            return ResponseEntity.status(200).body(user.get());
    }


    public ResponseEntity register(@RequestBody User user) {
        try {
            UserDTO registeredUser = userService.register(user);
            return ResponseEntity.status(201).body(registeredUser) ;
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(406).body(new ErrorDTO(e.getMessage()));
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity modifyUser(@PathVariable Integer id, @RequestBody UserRegistrationDTO modification) {
        try {
            UserDTO modifiedUser = userService.update(id, modification);
            return ResponseEntity.ok(modifiedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(406).body(new ErrorDTO(e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id , @RequestHeader(value = "Authorization") Integer loggedInUser) {
        if (id == loggedInUser) {
            userService.delete(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(403).body(new ErrorDTO("Don't have permission!"));
        }

    }




}
