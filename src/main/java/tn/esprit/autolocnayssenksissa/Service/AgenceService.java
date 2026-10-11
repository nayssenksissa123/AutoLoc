package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.AgenceRepository;
import tn.esprit.autolocnayssenksissa.domain.Agence;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceService implements IAgenceService {

    private final AgenceRepository agenceRepo;

    @Override
    public Agence ajouter(Agence agence) {
        return agenceRepo.save(agence);
    }

    @Override
    public void supprimerAgence(long id) {
        agenceRepo.deleteById(id);
    }

    @Override
    public Agence recupererAgence(long id) {
        return agenceRepo.findById(id).orElse(null);
    }

    @Override
    public List<Agence> recupererAgences() {
        return agenceRepo.findAll();
    }

    @Override
    public Agence updateAgence(Agence a) {
        return agenceRepo.save(a);
    }
}