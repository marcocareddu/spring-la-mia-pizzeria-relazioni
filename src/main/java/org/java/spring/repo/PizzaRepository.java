package org.java.spring.repo;

import java.util.List;

import org.java.spring.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	List<Pizza> findByNameContainingOrDescriptionContainingIgnoreCase(String name, String description);
	}