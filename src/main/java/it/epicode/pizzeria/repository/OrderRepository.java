package it.epicode.pizzeria.repository;

import it.epicode.pizzeria.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}