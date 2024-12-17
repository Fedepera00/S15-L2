package it.epicode.pizzeria.configuration;

import it.epicode.pizzeria.entity.*;
import it.epicode.pizzeria.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Autowired
    private PizzaRepository pizzaRepo;
    @Autowired
    private ToppingsRepository toppingsRepo;
    @Autowired
    private DrinksRepository drinksRepo;
    @Autowired
    private MenuRepository menuRepo;

    @Bean
    public Pizza createPizzaMargherita() {
        Pizza pizza = new Pizza();
        pizza.setName("Pizza Margherita");
        pizza.setCalories(1104);
        pizza.setIngredients("tomato, cheese");
        pizza.setPrice(4.99);
        return pizza;
    }

    @Bean
    public Pizza createPizzaHawaiian() {
        Pizza pizza = new Pizza();
        pizza.setName("Hawaiian Pizza");
        pizza.setCalories(1024);
        pizza.setIngredients("tomato, cheese, ham, pineapple");
        pizza.setPrice(6.49);
        return pizza;
    }

    @Bean
    public Pizza createPizzaSalami() {
        Pizza pizza = new Pizza();
        pizza.setName("Salami Pizza");
        pizza.setCalories(1160);
        pizza.setIngredients("tomato, cheese, salami");
        pizza.setPrice(5.99);
        return pizza;
    }

    @Bean
    public Toppings createCheese() {
        Toppings toppings = new Toppings();
        toppings.setName("Cheese");
        toppings.setCalories(92);
        toppings.setPrice(0.69);
        return toppings;
    }

    @Bean
    public Toppings createHam() {
        Toppings toppings = new Toppings();
        toppings.setName("Ham");
        toppings.setCalories(35);
        toppings.setPrice(0.99);
        return toppings;
    }

    @Bean
    public Toppings createOnions() {
        Toppings toppings = new Toppings();
        toppings.setName("Onions");
        toppings.setCalories(22);
        toppings.setPrice(0.69);
        return toppings;
    }

    @Bean
    public Toppings createPineapple() {
        Toppings toppings = new Toppings();
        toppings.setName("Pineapple");
        toppings.setCalories(24);
        toppings.setPrice(0.79);
        return toppings;
    }

    @Bean
    public Toppings createSalami() {
        Toppings toppings = new Toppings();
        toppings.setName("Salami");
        toppings.setCalories(86);
        toppings.setPrice(0.99);
        return toppings;
    }

    @Bean
    public Drinks createLemonade() {
        Drinks drinks = new Drinks();
        drinks.setName("Lemonade");
        drinks.setQuantity("0.33l");
        drinks.setCalories(128);
        drinks.setPrice(1.29);
        return drinks;
    }

    @Bean
    public Drinks createWater() {
        Drinks drinks = new Drinks();
        drinks.setName("Water");
        drinks.setQuantity("0.5l");
        drinks.setCalories(0);
        drinks.setPrice(1.29);
        return drinks;
    }

    @Bean
    public Drinks createWine() {
        Drinks drinks = new Drinks();
        drinks.setName("Wine");
        drinks.setQuantity("0.75l, 13%");
        drinks.setCalories(607);
        drinks.setPrice(7.49);
        return drinks;
    }

    @Bean
    public Menu createmenu() {
        Menu menu = new Menu();

        // Crea e salva le pizze
        Pizza margherita = createPizzaMargherita();
        pizzaRepo.save(margherita);
        Pizza hawaiian = createPizzaHawaiian();
        pizzaRepo.save(hawaiian);
        Pizza salami = createPizzaSalami();
        pizzaRepo.save(salami);

        menu.setPizze(Arrays.asList(margherita, hawaiian, salami));

        // Crea e salva i toppings
        Toppings cheese = createCheese();
        toppingsRepo.save(cheese);
        Toppings ham = createHam();
        toppingsRepo.save(ham);
        Toppings onions = createOnions();
        toppingsRepo.save(onions);
        Toppings pineapple = createPineapple();
        toppingsRepo.save(pineapple);
        Toppings salamiTopping = createSalami();
        toppingsRepo.save(salamiTopping);

        menu.setToppings(Arrays.asList(cheese, ham, onions, pineapple, salamiTopping));

        // Crea e salva le bevande
        Drinks lemonade = createLemonade();
        drinksRepo.save(lemonade);
        Drinks water = createWater();
        drinksRepo.save(water);
        Drinks wine = createWine();
        drinksRepo.save(wine);

        menu.setDrinks(Arrays.asList(lemonade, water, wine));

        return menu;
    }
}

