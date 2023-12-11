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
	private IngredientService ingredientService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private PromoService promoService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Ingredient pomodoro = new Ingredient("pomodoro");
		Ingredient mozzarella = new Ingredient("mozzarella");
		Ingredient acciughe = new Ingredient("acciughe");
		Ingredient origano = new Ingredient("origano");
		Ingredient aglio = new Ingredient("aglio");
		Ingredient salamePiccante = new Ingredient("salame piccante");
		Ingredient basilico = new Ingredient("basilico");
		Ingredient rosmarino = new Ingredient("rosmarino");
		Ingredient salsiccia = new Ingredient("salsiccia");
		Ingredient sale = new Ingredient("sale");
		Ingredient funghi = new Ingredient("funghi");
		Ingredient gorgonzola = new Ingredient("gorgonzola");
		Ingredient provola = new Ingredient("provola");
		Ingredient carciofi = new Ingredient("carciofi");
		Ingredient cotto = new Ingredient("prosciutto cotto");
		Ingredient olive = new Ingredient("olive");
		Ingredient olioOliva = new Ingredient("olio d'oliva");
		Ingredient parmigiano = new Ingredient("parmigiano");
		
		ingredientService.save(pomodoro);
		ingredientService.save(mozzarella);
		ingredientService.save(acciughe);
		ingredientService.save(origano);
		ingredientService.save(aglio);
		ingredientService.save(salamePiccante);
		ingredientService.save(basilico);
		ingredientService.save(rosmarino);
		ingredientService.save(salsiccia);
		ingredientService.save(sale);
		ingredientService.save(funghi);
		ingredientService.save(provola);
		ingredientService.save(gorgonzola);
		ingredientService.save(carciofi);
		ingredientService.save(cotto);
		ingredientService.save(olive);
		ingredientService.save(olioOliva);
		ingredientService.save(parmigiano);
		
		pizzaService.save(new Pizza("Bianca", "Pizza bianca", "https://wips.plug.it/cips/buonissimo.org/cms/2019/04/pizza-bianca-1.jpg", 3.00, olioOliva, rosmarino, sale));
		pizzaService.save(new Pizza("Margherita", "Pizza margherita", "https://wips.plug.it/cips/buonissimo.org/cms/2020/02/pizza-margherita.jpg", 5.00, pomodoro, mozzarella, basilico));
		pizzaService.save(new Pizza("Marinara", "Pizza marinara", "https://upload.wikimedia.org/wikipedia/commons/1/11/Pizza_marinara.jpg", 3.00, pomodoro, aglio, origano));
		pizzaService.save(new Pizza("Diavola", "Pizza diavola", "https://www.lucianopignataro.it/wp-content/uploads/2023/02/Elementi-Pizzeria-Diavola-480x480.png", 5.00, pomodoro, mozzarella, salamePiccante));
		pizzaService.save(new Pizza("Boscaiola", "Pizza boscaiola", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqI2bAJj45Kfb35nZLWBvBZDBTuk_HnH8t0x3WRm-wQT8nvVTZe76UfBWZxDKf9qLICrg&usqp=CAU", 6.00, pomodoro, mozzarella, salsiccia, funghi));
		pizzaService.save(new Pizza("Quattro formaggi", "Pizza Quattro formaggi", "https://www.petitchef.it/imgupl/recipe/pizza-ai-quattro-formaggi--459380p719602.jpg", 4.00, mozzarella, parmigiano, gorgonzola, provola ));
		pizzaService.save(new Pizza("Quattro stagioni", "Pizza Quattro stagioni", "https://www.petitchef.it/imgupl/recipe/pizza-4-stagioni--449891p695427.jpg", 4.00, pomodoro, mozzarella, carciofi, cotto, funghi, olive));
		pizzaService.save(new Pizza("Capricciosa", "Pizza Capricciosa", "https://www.pizzanapoletanadoc.it/wp-content/uploads/2019/04/capricciosa-pizza-napoletana-doc.jpg", 8.00, pomodoro, mozzarella, carciofi, cotto, funghi, olive));
		pizzaService.save(new Pizza("Romana", "Pizza Romana", "https://www.50toppizza.it/wp-content/uploads/2019/02/pizza-romana-pignataro.jpg", 3.00, pomodoro, mozzarella, acciughe, origano));
	
		List<Pizza> pizzas = pizzaService.findAll();
		
		promoService.save(new Promo(LocalDate.parse("2023-12-25"), LocalDate.parse("2024-01-06"), "Promo Natalizia", pizzas.get(0)));
		promoService.save(new Promo(LocalDate.parse("2022-12-30"), LocalDate.parse("2022-12-31"), "Promo Fine Anno", pizzas.get(1)));
		promoService.save(new Promo(LocalDate.parse("2024-01-07"), LocalDate.parse("2024-01-31"), "Promo Nuovo Anno", pizzas.get(2)));
		promoService.save(new Promo(LocalDate.parse("2024-02-01"), LocalDate.parse("2024-02-20"), "Promo Carnevale", pizzas.get(3)));
	}
}
