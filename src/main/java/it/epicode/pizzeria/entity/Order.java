package it.epicode.pizzeria.entity;

import it.epicode.pizzeria.enums.Stato;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_ordine")
    private Integer numeroOrdine;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @Column(name = "numero_coperti")
    private Integer numeroCoperti;

    @Column(name = "importo_totale")
    private Double importoTotale;

    @Column(name = "ora_acquisizione")
    private LocalTime oraAcquisizione;

    // Aggiunta relazione (se necessaria) con Tavolo
    @ManyToOne
    @JoinColumn(name = "tavolo_id")
    private Tavolo tavolo;
}