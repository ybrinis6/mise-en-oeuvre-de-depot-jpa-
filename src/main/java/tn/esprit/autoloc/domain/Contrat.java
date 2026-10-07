package tn.esprit.autoloc.domain;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contrat")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @Column(nullable = false)
    private LocalDate dateSignature;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @Column(nullable = false)
    private boolean valide;

    // Propriétaire du un-à-un : id_reservation, avec unicité (1 réservation = 1 contrat)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reservation", nullable = false, unique = true)
    private Reservation reservation;

    // Composition : les paiements dépendent du contrat
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paiement> paiements = new ArrayList<>();
}