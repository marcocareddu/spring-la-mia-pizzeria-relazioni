package org.java.spring.services;

import java.util.List;

import org.java.spring.Promo;
import org.java.spring.repo.PromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoService {

	@Autowired
	private PromoRepository promoRepository;
	
	public List<Promo> findAll() {
		return promoRepository.findAll();
	}
	public Promo findById(int id) {
		return promoRepository.findById(id).get();
	}
	public void save(Promo promo) {
		promoRepository.save(promo);
	}
	public void deleteById(int id) {
		promoRepository.deleteById(id);
	}
}
