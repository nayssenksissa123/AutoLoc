package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.PaiementRepository;
import tn.esprit.autolocnayssenksissa.domain.Paiement;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService implements IPaiementService {

    private final PaiementRepository paiementRepo;

    @Override
    public Paiement ajouter(Paiement paiement) {
        return paiementRepo.save(paiement);
    }

    @Override
    public void supprimerPaiement(long id) {
        paiementRepo.deleteById(id);
    }

    @Override
    public Paiement recupererPaiement(long id) {
        return paiementRepo.findById(id).orElse(null);
    }

    @Override
    public List<Paiement> recupererPaiements() {
        return paiementRepo.findAll();
    }

    @Override
    public Paiement updatePaiement(Paiement p) {
        return paiementRepo.save(p);
    }
}