package it.epicode.pizzeria.entity;

import it.epicode.pizzeria.enums.Stato;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tavoli")
public class Tavolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_coperti_massimo")
    private Integer numeroCopertiMassimo;

    @Enumerated(EnumType.STRING)
    private Stato stato;
}