package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Contrat;
import java.util.List;

public interface IContratService {
    Contrat ajouter(Contrat contrat);
    void supprimerContrat(int id);
    Contrat recupererContrat(int id);
    List<Contrat> recupererContrats();
    Contrat updateContrat(Contrat c);
}