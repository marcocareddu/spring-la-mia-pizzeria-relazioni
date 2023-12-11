package org.java.spring.services;

import java.util.List;

import org.java.spring.Ingredient;
import org.java.spring.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
	public void deleteById(int id) {
		ingredientRepository.deleteById(id);
	}
}
