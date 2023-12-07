package org.java.spring;

import java.util.List;

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
public class MainController {

	@Autowired
	private PizzaService pizzaService;

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
		model.addAttribute("list", pizza);
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
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		model.addAttribute("action", "edit");
		
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
}