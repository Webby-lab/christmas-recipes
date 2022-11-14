package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.RecipesDTO;
import azure.christmas_recipes.models.dtos.UserRegistrationDTO;
import azure.christmas_recipes.models.entities.Recipe;
import azure.christmas_recipes.models.entities.User;
import azure.christmas_recipes.repositories.RecipeRepository;
import azure.christmas_recipes.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    UserRepository userRepository;
    RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }


    public Recipe getRecipeById(Integer id) {
        return recipeRepository.findAll().stream()
                .filter(recipe -> recipe.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public RecipesDTO findUserRecipies(int userId) throws NoSuchUserException {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) throw  new NoSuchUserException();
        RecipesDTO usersRecipies = new RecipesDTO(userId, user.getFavouriteRecipies());
        return usersRecipies;
    }

}
