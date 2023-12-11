package org.java.spring;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Promo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private LocalDate startPromo;
	private LocalDate endPromo;
	private String title;
	
//	DB Relation
    @ManyToOne
    private Pizza pizza;
	
//	Constructors
	public Promo() {}
	public Promo(LocalDate startPromo, LocalDate endPromo, String title, Pizza pizza) {
		setStartPromo(startPromo);
		setEndPromo(endPromo);
		setTitle(title);
		setPizza(pizza);
	}

//	Getters $ Setters
	public LocalDate getStartPromo() {
		return startPromo;
	}
	public void setStartPromo(LocalDate startPromo) {
		this.startPromo = startPromo;
	}
	public LocalDate getEndPromo() {
		return endPromo;
	}
	public void setEndPromo(LocalDate endPromo) {
		this.endPromo = endPromo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	
}
