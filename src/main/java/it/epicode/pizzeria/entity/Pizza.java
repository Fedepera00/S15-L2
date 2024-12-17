package it.epicode.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@NamedQuery(name = "Trova_tutto_Pizza", query = "SELECT a FROM Pizza a")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "price")
    private Double price;

    @Column(name = "ingredients")
    private String ingredients;

    @ManyToOne
    @JoinColumn(name = "menu_id")  // Aggiungi la chiave esterna che punta al menu
    private Menu menu;

    // Costruttore senza argomenti (necessario per JPA)
    public Pizza() {
    }

    // Costruttore con parametri
    public Pizza(String name, int calories, double price, String ingredients) {
        this.name = name;
        this.calories = calories;
        this.price = price;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
