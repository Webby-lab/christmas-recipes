package azure.christmas_recipes.controllers;

import azure.christmas_recipes.repositories.IngredientRepository;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import azure.christmas_recipes.repositories.RecipeRepository;
import azure.christmas_recipes.services.IngredientService;
import azure.christmas_recipes.services.RecipeIngredientsService;
import azure.christmas_recipes.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecipeController {
    RecipeIngredientsService recipeIngredientsService;
    IngredientService ingredientService;
    RecipeService recipeService;


    @Autowired

    public RecipeController(RecipeIngredientsService recipeIngredientsService, IngredientService ingredientService, RecipeService recipeService) {
        this.recipeIngredientsService = recipeIngredientsService;
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }




    @GetMapping("/")
    public String renderMainPage(Model model) {
        model.addAttribute("recipies", recipeService.findAll());
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
