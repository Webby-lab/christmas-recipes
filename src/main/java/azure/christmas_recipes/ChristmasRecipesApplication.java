package azure.christmas_recipes;

import azure.christmas_recipes.models.entities.*;
import azure.christmas_recipes.repositories.IngredientRepository;
import azure.christmas_recipes.repositories.RecipeIngredientsRepository;
import azure.christmas_recipes.repositories.RecipeRepository;
import azure.christmas_recipes.repositories.UserRepository;
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
	UserRepository userRepository;
	@Autowired
	public ChristmasRecipesApplication(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeIngredientsRepository recipeIngredientsRepository, UserRepository userRepository) {
		this.ingredientRepository = ingredientRepository;
		this.recipeRepository = recipeRepository;
		this.recipeIngredientsRepository = recipeIngredientsRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChristmasRecipesApplication.class, args);

	}
	@Override
	public void run(String... args) throws Exception {
		Ingredient sugar = new Ingredient("sugar", Unit.KG);
		Ingredient milk = new Ingredient("milk", Unit.LITER);
		Ingredient butter = new Ingredient("butter", Unit.G);
		Ingredient flour = new Ingredient("flour", Unit.KG);
		Ingredient egg = new Ingredient("egg", Unit.PIECE);

		ingredientRepository.saveAll(Arrays.asList(sugar, milk, butter, flour, egg));
		Recipe pikota = new Recipe("Piskóta", "tojás összekutyul", 1.0, Level.EASY);
//		recipeRepository.save(pikota);
		Recipe linzer = new Recipe("Linzer", "vaj, cukor, liszt, tojás, összegyúrni, kisütni", 1.5, Level.MEDIUM);
//		recipeRepository.save(linzer);
		Recipe kifli = new Recipe("Kifli", "vaj, cukor, liszt, tojás, összekeverni, kisütni", 0.5, Level.EASY);
		RecipeIngredients pisk = new RecipeIngredients(1,"sugar",  0.2);
		RecipeIngredients pisk2 = new RecipeIngredients(1, "egg",  6.0);
		RecipeIngredients pisk3 = new RecipeIngredients(1, "flour",  0.3);
		recipeIngredientsRepository.saveAll(Arrays.asList(pisk, pisk2, pisk3));

		RecipeIngredients linzer1 = new RecipeIngredients(2, "sugar", 0.3);
		RecipeIngredients linzer2 = new RecipeIngredients(2, "flour", 0.5);
		RecipeIngredients linzer3 = new RecipeIngredients(2, "egg", 1.0);
		RecipeIngredients linzer4 = new RecipeIngredients(2, "butter", 0.25);
		recipeIngredientsRepository.saveAll(Arrays.asList(linzer1, linzer2, linzer3, linzer4));

		RecipeIngredients kifli1 = new RecipeIngredients(3, "sugar", 0.3);
		RecipeIngredients kifli2 = new RecipeIngredients(3, "flour", 0.5);
		RecipeIngredients kifli3 = new RecipeIngredients(3, "egg", 1.0);
		RecipeIngredients kifli4 = new RecipeIngredients(3, "butter", 0.25);
		recipeIngredientsRepository.saveAll(Arrays.asList(kifli1, kifli2, kifli3, kifli4));

		User pisti = new User("Pisti", "pisti@pisti.com", "password", Arrays.asList(pikota, linzer));
		User piri = new User("Piri", "piri@pisti.com", "passpiri", Arrays.asList(kifli));
		userRepository.saveAll(Arrays.asList(pisti, piri));

	}
}
