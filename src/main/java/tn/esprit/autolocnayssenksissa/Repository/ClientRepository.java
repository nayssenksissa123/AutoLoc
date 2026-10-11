package tn.esprit.autolocnayssenksissa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocnayssenksissa.domain.Client;

@Repository

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
