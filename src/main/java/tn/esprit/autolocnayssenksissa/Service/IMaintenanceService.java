package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouter(Maintenance maintenance);
    void supprimerMaintenance(long id);
    Maintenance recupererMaintenance(long id);
    List<Maintenance> recupererMaintenances();
    Maintenance updateMaintenance(Maintenance m);
}