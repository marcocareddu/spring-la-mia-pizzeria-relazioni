package org.java.spring;

import java.time.LocalDate;
import java.util.List;

import org.java.spring.services.IngredientService;
import org.java.spring.services.PizzaService;
import org.java.spring.services.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private PromoService promoService;
	
	@Autowired
	private IngredientService ingredientService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		pizzaService.save(new Pizza("Bianca", "Pizza con olio d'oliva, rosmarino e sale", "https://wips.plug.it/cips/buonissimo.org/cms/2019/04/pizza-bianca-1.jpg", 3.00));
		pizzaService.save(new Pizza("Margherita", "Pizza con pomodoro, mozzarella e basilico", "https://wips.plug.it/cips/buonissimo.org/cms/2020/02/pizza-margherita.jpg", 5.00));
		pizzaService.save(new Pizza("Marinara", "Pizza con pomodoro, aglio e origano", "https://upload.wikimedia.org/wikipedia/commons/1/11/Pizza_marinara.jpg", 3.00));
		pizzaService.save(new Pizza("Diavola", "Pizza con pomodoro, mozzarella e salame piccante", "https://www.lucianopignataro.it/wp-content/uploads/2023/02/Elementi-Pizzeria-Diavola-480x480.png", 5.00));
		pizzaService.save(new Pizza("Boscaiola", "Pizza con pomodoro, mozzarella, salsiccia e funghi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqI2bAJj45Kfb35nZLWBvBZDBTuk_HnH8t0x3WRm-wQT8nvVTZe76UfBWZxDKf9qLICrg&usqp=CAU", 6.00));
		pizzaService.save(new Pizza("Quattro formaggi", "Pizza con mozzarella, parmigiano, gorgonzola e provola (quarto formaggio variabile)", "https://www.petitchef.it/imgupl/recipe/pizza-ai-quattro-formaggi--459380p719602.jpg", 4.00));
		pizzaService.save(new Pizza("Quattro stagioni", "Pizza con ppomodoro, mozzarella, carciofi, prosciutto cotto, funghi e olive", "https://www.petitchef.it/imgupl/recipe/pizza-4-stagioni--449891p695427.jpg", 4.00));
		pizzaService.save(new Pizza("Capricciosa", "Pizza con pomodoro, mozzarella, carciofi, prosciutto cotto, funghi e olive", "https://www.pizzanapoletanadoc.it/wp-content/uploads/2019/04/capricciosa-pizza-napoletana-doc.jpg", 8.00));
		pizzaService.save(new Pizza("Romana", "Pizza con pomodoro, mozzarella, acciughe e origano", "https://www.50toppizza.it/wp-content/uploads/2019/02/pizza-romana-pignataro.jpg", 3.00));
	
		List<Pizza> pizzas = pizzaService.findAll();
		
		promoService.save(new Promo(LocalDate.parse("2023-12-25"), LocalDate.parse("2024-01-06"), "Promo Natalizia", pizzas.get(0)));
		promoService.save(new Promo(LocalDate.parse("2022-12-30"), LocalDate.parse("2022-12-31"), "Promo Fine Anno", pizzas.get(1)));
		promoService.save(new Promo(LocalDate.parse("2024-01-07"), LocalDate.parse("2024-01-31"), "Promo Nuovo Anno", pizzas.get(2)));
		promoService.save(new Promo(LocalDate.parse("2024-02-01"), LocalDate.parse("2024-02-20"), "Promo Carnevale", pizzas.get(3)));
	}
}
