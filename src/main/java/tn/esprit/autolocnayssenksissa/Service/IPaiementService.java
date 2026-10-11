package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement ajouter(Paiement paiement);
    void supprimerPaiement(long id);
    Paiement recupererPaiement(long id);
    List<Paiement> recupererPaiements();
    Paiement updatePaiement(Paiement p);
}