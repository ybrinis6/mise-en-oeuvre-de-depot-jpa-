package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    // Propriétaire : colonne id_vehicule
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule", nullable = false)
    private Vehicule vehicule;

    // Inverse du un-à-un : "reservation" est le champ dans Contrat
    @OneToOne(mappedBy = "reservation")
    private Contrat contrat;
}