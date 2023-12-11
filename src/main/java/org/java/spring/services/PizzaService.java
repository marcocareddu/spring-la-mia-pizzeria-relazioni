package org.java.spring.services;

import java.util.List;

import org.java.spring.Pizza;
import org.java.spring.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}
	public Pizza findById(int id) {
		return pizzaRepository.findById(id).get();
	}
	public List<Pizza> findByName(String searched) {
		return pizzaRepository.findByNameContainingOrDescriptionContainingIgnoreCase(searched, searched);
	}
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}
	public void deleteById(int id) {
		pizzaRepository.deleteById(id);
	}
}