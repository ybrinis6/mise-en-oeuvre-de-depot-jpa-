package tn.esprit.autoloc.domain;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    @Column(nullable = false, length = 100)
    private String libelle;

    @ManyToMany(mappedBy = "equipements")
    private Set<Vehicule> vehicules = new HashSet<>();
}