package org.java.spring;

import org.java.spring.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;
	
	@GetMapping("/ingredients/create")
	public String create(Model model) {

		model.addAttribute("ingredient", new Ingredient());
		model.addAttribute("action", "create");
		return "ingredientForm";
	}
	
	@PostMapping("/ingredients/create")
	public String store(Model model, @Valid @ModelAttribute Ingredient ingredient, BindingResult bindingResult) {

//		if (bindingResult.hasErrors()) {
//			System.out.println("Errors: \n" + bindingResult);
//			model.addAttribute("ingredient", ingredient);
//			return "form";
//		}

		System.out.println("Ingrediente " + ingredient.getName() + " aggiunto");
		ingredientService.save(ingredient);
		return "redirect:/index-ingredients";
	}
	
	@PostMapping("/ingredients/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		ingredientService.deleteById(id);
		return "redirect:/index-ingredients";
	}
	
	
}
