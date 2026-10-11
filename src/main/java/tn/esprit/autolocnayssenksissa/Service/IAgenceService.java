package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Agence;
import java.util.List;

public interface IAgenceService {
    Agence ajouter(Agence agence);
    void supprimerAgence(long id);
    Agence recupererAgence(long id);
    List<Agence> recupererAgences();
    Agence updateAgence(Agence a);
}