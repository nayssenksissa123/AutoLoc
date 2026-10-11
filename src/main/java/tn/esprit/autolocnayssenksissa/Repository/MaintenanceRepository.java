package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocnayssenksissa.domain.Maintenance;
@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
}
