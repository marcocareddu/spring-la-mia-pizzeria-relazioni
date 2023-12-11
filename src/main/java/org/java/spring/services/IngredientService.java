package org.java.spring.services;

import java.util.List;
import org.java.spring.Ingredient;
import org.java.spring.Pizza;
import org.java.spring.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    @Autowired
    private PizzaService pizzaService;
    
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}
	public Ingredient findById(int id) {
		return ingredientRepository.findById(id).get();
	}
	public void save(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

    public void deleteById(int id) {
        Ingredient ingredient = ingredientRepository.findById(id).get();

        if (ingredient != null) {
            List<Pizza> pizzas = ingredient.getPizzas();

            if (pizzas != null) {
                for (Pizza pizza : pizzas) {
                    pizza.getIngredients().remove(ingredient);
                    pizzaService.save(pizza);
                }
            }
            ingredientRepository.deleteById(id);
        }
    }
}
