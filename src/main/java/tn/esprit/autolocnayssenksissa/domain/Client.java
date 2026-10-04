package tn.esprit.autolocnayssenksissa.domain;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;

    private String telephone;

    @Column(unique = true)
    private String numPermis;

    private LocalDate dateInscription;
}
