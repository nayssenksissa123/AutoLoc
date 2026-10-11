package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocnayssenksissa.domain.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
