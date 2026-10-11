package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocnayssenksissa.domain.Equipement;

@Repository

public interface EquipementRepository extends JpaRepository<Equipement ,Long> {
}
