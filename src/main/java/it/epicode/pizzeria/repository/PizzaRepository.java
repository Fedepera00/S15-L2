package it.epicode.pizzeria.repository;

import it.epicode.pizzeria.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}