package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Employe;
import java.util.List;

public interface IEmployeService {
    Employe ajouter(Employe employe);
    void supprimerEmploye(long id);
    Employe recupererEmploye(long id);
    List<Employe> recupererEmployes();
    Employe updateEmploye(Employe e);
}