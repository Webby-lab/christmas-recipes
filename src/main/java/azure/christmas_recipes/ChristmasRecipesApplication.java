package azure.christmas_recipes;

import azure.christmas_recipes.models.*;
import azure.christmas_recipes.repositories.IngredientRepository;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import azure.christmas_recipes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ChristmasRecipesApplication implements CommandLineRunner {
	IngredientRepository ingredientRepository;
	RecipeRepository recipeRepository;
	RecipeIngredientsRepository recipeIngredientsRepository;
	@Autowired
	public ChristmasRecipesApplication(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeIngredientsRepository recipeIngredientsRepository) {
		this.ingredientRepository = ingredientRepository;
		this.recipeRepository = recipeRepository;
		this.recipeIngredientsRepository = recipeIngredientsRepository;
	}

	public ChristmasRecipesApplication(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
		this.ingredientRepository = ingredientRepository;
		this.recipeRepository = recipeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChristmasRecipesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ingredient sugar = new Ingredient("sugar", Unit.KG);
		Ingredient milk = new Ingredient("milk", Unit.LITER);
		Ingredient butter = new Ingredient("butter", Unit.G);
		ingredientRepository.saveAll(Arrays.asList(sugar, milk, butter));
		Recipe pikota = new Recipe("Piskóta", "tojás összekutyul", 1.0, Level.EASY);
		recipeRepository.save(pikota);
		RecipeIngredients pisk = new RecipeIngredients(1, 2, 0.2);
		RecipeIngredients pisk2 = new RecipeIngredients(1, 1, 0.3);
		recipeIngredientsRepository.saveAll(Arrays.asList(pisk, pisk2));
	}
}
