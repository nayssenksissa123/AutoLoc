package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocnayssenksissa.domain.Vehicule;
import org.springframework.stereotype.Repository;;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {
}
