package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocnayssenksissa.domain.Contrat;

@Repository

public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
