package org.java.spring;

import java.util.List;
import org.java.spring.services.IngredientService;
import org.java.spring.services.PizzaService;
import org.java.spring.services.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private PromoService promoService;

	@GetMapping
	public String getPizzas(Model model, @RequestParam(required = false) String searched) {
		List<Pizza> pizzas = searched == null ? pizzaService.findAll() : pizzaService.findByName(searched);
		model.addAttribute("list", pizzas);
		model.addAttribute("searched", searched == null ? "" : searched);
		return "index";
	}

	@GetMapping("/detail/{id}")
	public String getPizza(Model model, @PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		List<Promo> promoList = pizza.getPromos();
		
		model.addAttribute("list", pizza);
		model.addAttribute("id", id);
		model.addAttribute("promos", promoList);
		return "detail";
	}

	@GetMapping("/create")
	public String create(Model model) {

		model.addAttribute("pizza", new Pizza());
		model.addAttribute("action", "create");
		return "form";
	}
	@PostMapping("/create")
	public String store(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errors: \n" + bindingResult);
			model.addAttribute("pizza", pizza);
			return "form";
		}

		System.out.println("Pizza " + pizza.getName() + " aggiunta");

		pizzaService.save(pizza);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String editPizza(Model model, @PathVariable int id) {
		
		List<Ingredient> ingredients = ingredientService.findAll();

		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		model.addAttribute("action", "edit");
		model.addAttribute("ingredients", ingredients);
		
		return "form";
	}

	@PostMapping("/edit/{id}")
	public String updatePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			System.out.println("Errors: \n" + bindingResult);
			model.addAttribute("pizza", pizza);
			return "form";
		}

		System.out.println("Pizza " + pizza.getName() + " modificata");
		
		pizzaService.save(pizza);
		return "redirect:/";
	}

	@PostMapping("/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		pizzaService.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/index-ingredients")
	public String getIngredients(Model model) {
		
		List<Ingredient> ingredients = ingredientService.findAll();
		model.addAttribute("list", ingredients);
		
		return "IndexIngredients";
	}
	
	@GetMapping("/promos")
	public String getPromos(Model model) {

		List<Promo> promos = promoService.findAll();
		model.addAttribute("list", promos);

		return "IndexPromo";
	}
	
}