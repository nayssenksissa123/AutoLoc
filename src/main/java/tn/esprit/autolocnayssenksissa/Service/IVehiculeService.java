package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule ajouter(Vehicule vehicule);
    void supprimerVehicule(long id);
    Vehicule recupererVehicule(long id);
    List<Vehicule> recupererVehicules();
    Vehicule updateVehicule(Vehicule v);
}