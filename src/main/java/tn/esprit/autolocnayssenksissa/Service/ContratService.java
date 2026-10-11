package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.ContratRepository;
import tn.esprit.autolocnayssenksissa.domain.Contrat;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService {

    private final ContratRepository contratRepo;

    @Override
    public Contrat ajouter(Contrat contrat) {
        return null;
    }

    @Override
    public void supprimerContrat(int id) {

    }

    @Override
    public Contrat recupererContrat(int id) {
        return null;
    }

    @Override
    public List<Contrat> recupererContrats() {
        return List.of();
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return null;
    }
}
