package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.RecipeDTO;
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
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
    private UserRepository userRepository;
    private RecipeRepository recipeRepository;
    private FavouriteRecipeService favouriteRecipeService;
    @Autowired
    public RecipeServiceImpl(UserRepository userRepository, RecipeRepository recipeRepository, FavouriteRecipeService favouriteRecipeService) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
        this.favouriteRecipeService = favouriteRecipeService;
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
    public RecipesDTO findUserRecipes(int userId) throws NoSuchUserException {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) throw  new NoSuchUserException();
        RecipesDTO userRecipes = convert(userId, user.getUserRecipes());
        return userRecipes;

    }

    @Override
    public RecipeDTO convert(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
            recipeDTO.setName(recipe.getName());
            recipeDTO.setCookingTime(recipe.getCookingTime());
            recipeDTO.setLevel(recipe.getLevel());
            recipeDTO.setPopularity(favouriteRecipeService.getPopularityOfRecipe(recipe.getName()));
        return recipeDTO;
    }

    @Override
    public RecipesDTO convert(int userId, List<Recipe> recipes) {
        RecipesDTO recipesDTO = new RecipesDTO();
        recipesDTO.setUserId(userId);
        recipesDTO.setRecipes(recipes.stream().map(this::convert).collect(Collectors.toList()));
        recipesDTO.setCount(recipes.size());
        return recipesDTO;
    }

    @Override
    public List<String> getAllRecipeName() {

        return recipeRepository.findAllByRecipeName();
    }

}
