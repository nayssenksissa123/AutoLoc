package tn.esprit.autolocnayssenksissa.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "vehicule")
public class Vehicule {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long idvehicule;
        private String immatruclation;
        private String modele;
        @Enumerated(EnumType.STRING)
        private CategorieVehicule categorie;
        private BigDecimal tarifjournalier;
        @Enumerated(EnumType.STRING)
        private StatutVehicule statut;
    }

