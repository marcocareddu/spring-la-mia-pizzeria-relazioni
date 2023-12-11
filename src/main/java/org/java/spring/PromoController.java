package org.java.spring;
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

import jakarta.validation.Valid;


@Controller
public class PromoController {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private PromoService promoService;
	
	
	@GetMapping("/promos/create")
	public String create(Model model) {

		model.addAttribute("promo", new Promo());
		model.addAttribute("action", "create");
		return "promo";
	}
	
	@PostMapping("/promos/create")
	public String store(Model model, @Valid @ModelAttribute Promo promo, BindingResult bindingResult) {

		System.out.println("Promozione " + promo.getTitle() + " aggiunto");
		promoService.save(promo);
		return "redirect:/promos";
	}
	
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
	
	@PostMapping("/promos/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		promoService.deleteById(id);
		return "redirect:/promos";
	}
	
}
