package org.java.spring;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Promo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private LocalDate startPromo;
	private LocalDate endPromo;
	private String title;
	
//	Constructors
	private Promo() {}
	private Promo(LocalDate startPromo, LocalDate endPromo, String title) {
		setStartPromo(startPromo);
		setEndPromo(endPromo);
		setTitle(title);
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
	
	
}
