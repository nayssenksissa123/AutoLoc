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
        return contratRepo.save(contrat);
    }

    @Override
    public void supprimerContrat(Long id) {
        contratRepo.deleteById(id);
    }

    @Override
    public Contrat recupererContrat(Long id) {
        return contratRepo.findById(id).orElse(null);
    }

    @Override
    public List<Contrat> recupererContrats() {
        return contratRepo.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepo.save(c);
    }
}