package it.epicode.pizzeria.runners;

import it.epicode.pizzeria.entity.*;
import it.epicode.pizzeria.enums.Stato;
import it.epicode.pizzeria.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalTime;
import java.util.Collections;

@Component
public class DataInitializerRunner implements CommandLineRunner {

    private final TavoloRepository tavoloRepo;
    private final PizzaRepository pizzaRepo;
    private final DrinksRepository drinksRepo;
    private final MenuRepository menuRepo;
    private final OrderRepository orderRepo;

    public DataInitializerRunner(TavoloRepository tavoloRepo, PizzaRepository pizzaRepo,
                                 DrinksRepository drinksRepo, MenuRepository menuRepo, OrderRepository orderRepo) {
        this.tavoloRepo = tavoloRepo;
        this.pizzaRepo = pizzaRepo;
        this.drinksRepo = drinksRepo;
        this.menuRepo = menuRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Tavolo
        Tavolo tavolo = new Tavolo();
        tavolo.setNumeroCopertiMassimo(4);
        tavolo.setStato(Stato.LIBERO);
        tavoloRepo.save(tavolo);

        // Pizza
        Pizza margherita = new Pizza();
        margherita.setName("Margherita");
        margherita.setCalories(800);
        margherita.setPrice(4.99);
        pizzaRepo.save(margherita);

        // Bevanda
        Drinks cola = new Drinks();
        cola.setName("Cola");
        cola.setCalories(150);
        cola.setPrice(2.50);
        drinksRepo.save(cola);

        // Menu
        Menu menu = new Menu();
        menu.setPizze(Collections.singletonList(margherita));  // La pizza è già salvata
        menu.setDrinks(Collections.singletonList(cola));  // Aggiungi la bevanda salvata
        menuRepo.save(menu);

        // Order
        Order ordine = new Order();
        ordine.setNumeroOrdine(1);
        ordine.setStato(Stato.IN_CORSO);
        ordine.setNumeroCoperti(4);
        ordine.setImportoTotale(4.99 + 2.50); // somma esempio
        ordine.setOraAcquisizione(LocalTime.now());
        ordine.setTavolo(tavolo);
        orderRepo.save(ordine);

        System.out.println("Inizializzazione dati completata con successo!");
    }
}
