package it.epicode.pizzeria.repository;

import it.epicode.pizzeria.entity.Tavolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TavoloRepository extends JpaRepository<Tavolo, Long> {
}