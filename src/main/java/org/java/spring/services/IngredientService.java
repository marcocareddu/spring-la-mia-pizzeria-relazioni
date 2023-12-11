package org.java.spring.services;

import java.util.List;
import java.util.Optional;

import org.java.spring.Ingredient;
import org.java.spring.Pizza;
import org.java.spring.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class IngredientService {

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

	@Transactional
    public void deleteById(int id) {
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);

        if (ingredientOptional.isPresent()) {
            Ingredient ingredient = ingredientOptional.get();
            List<Pizza> pizzas = ingredient.getPizzas();

            if (pizzas != null) {
                for (Pizza pizza : pizzas) {
                    pizza.getIngredients().remove(ingredient);
                }
            }
            
            ingredientRepository.deleteById(id);
        }
    }
	
}
