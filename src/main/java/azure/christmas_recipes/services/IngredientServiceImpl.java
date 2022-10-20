package azure.christmas_recipes.services;

import azure.christmas_recipes.models.Ingredient;
import azure.christmas_recipes.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServiceImpl implements IngredientService {
    IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}
