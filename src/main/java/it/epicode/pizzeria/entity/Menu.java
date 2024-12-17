package it.epicode.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NamedQuery(name = "Trova_tutto_Menu", query = "SELECT a FROM Menu a")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id") // Chiave esterna nella tabella "Pizza"
    private List<Pizza> pizze = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id") // Chiave esterna nella tabella "Toppings"
    private List<Toppings> toppings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id") // Chiave esterna nella tabella "Drinks"
    private List<Drinks> drinks = new ArrayList<>();

    @Override
    public String toString() {
        return "Menu {" +
                "pizze=" + pizze +
                ", toppings=" + toppings +
                ", drinks=" + drinks +
                '}';
    }

    public void printMenu() {
        System.out.println("### PIZZAS ###");
        pizze.forEach(System.out::println);

        System.out.println("\n### TOPPINGS ###");
        toppings.forEach(System.out::println);

        System.out.println("\n### DRINKS ###");
        drinks.forEach(System.out::println);
    }
}
