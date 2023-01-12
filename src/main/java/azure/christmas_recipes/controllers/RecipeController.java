package azure.christmas_recipes.controllers;

import azure.christmas_recipes.repositories.IngredientRepository;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import azure.christmas_recipes.repositories.RecipeRepository;
import azure.christmas_recipes.services.IngredientService;
import azure.christmas_recipes.services.RecipeIngredientsService;
import azure.christmas_recipes.services.RecipeService;
import azure.christmas_recipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RecipeController {
    RecipeIngredientsService recipeIngredientsService;
    IngredientService ingredientService;
    RecipeService recipeService;
    UserService userService;


    @Autowired
    public RecipeController(RecipeIngredientsService recipeIngredientsService, IngredientService ingredientService, RecipeService recipeService, UserService userService) {
        this.recipeIngredientsService = recipeIngredientsService;
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String renderMainPage(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        List<String> allRecipes = recipeService.getAllRecipeName();
        model.addAttribute("recipeNames", allRecipes);
        model.addAttribute("shoppingList", recipeIngredientsService.getIngredientsListByRecipeName(allRecipes));
        return "main";
    }
    @GetMapping("/{id}")
    public String renderRecipePage(Model model, @PathVariable(value = "id") Integer id) {
        model.addAttribute("recipe", recipeService.getRecipeById(id));
        String name = recipeService.getRecipeById(id).getName();
        model.addAttribute("ingredients", recipeIngredientsService.getIngredientsByRecipeName(name));
        return "recipePage";
    }


}
