package org.java.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PromoController {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private PromoService promoService;
	
	@GetMapping("/detail/{id}/promo")
	public String getPromoPage(Model model, @PathVariable int id) {
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		model.addAttribute("promo", new Promo());
		return "promo";
	}
	
	@PostMapping("/detail/{id}/promo")
	public String storePromo(@PathVariable int id, @ModelAttribute Promo promo) {
		
		Pizza pizza = pizzaService.findById(id);
		Promo newPromo = new Promo(promo.getStartPromo(), promo.getEndPromo(), promo.getTitle(), pizza);
		promoService.save(newPromo);

		return "redirect:/";
	}
}
