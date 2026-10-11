package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocnayssenksissa.domain.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}