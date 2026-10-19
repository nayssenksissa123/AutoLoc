package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Contrat;
import java.util.List;

public interface IContratService {
    Contrat ajouter(Contrat contrat);
    void supprimerContrat(Long id);
    Contrat recupererContrat(Long id);
    List<Contrat> recupererContrats();
    Contrat updateContrat(Contrat c);
}