package org.java.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromoController {

	@Autowired
	private PizzaService pizzaService;

	
	@GetMapping("/promo")
	public String getPromoPage(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		return "promo";
	}
}
