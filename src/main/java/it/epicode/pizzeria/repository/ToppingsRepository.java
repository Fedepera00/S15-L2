package it.epicode.pizzeria.repository;

import it.epicode.pizzeria.entity.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingsRepository extends JpaRepository<Toppings, Long> {
}