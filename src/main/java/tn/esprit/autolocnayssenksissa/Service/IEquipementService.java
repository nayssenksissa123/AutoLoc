package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement ajouter(Equipement equipement);
    void supprimerEquipement(long id);
    Equipement recupererEquipement(long id);
    List<Equipement> recupererEquipements();
    Equipement updateEquipement(Equipement e);
}