package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.MaintenanceRepository;
import tn.esprit.autolocnayssenksissa.domain.Maintenance;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepo;

    @Override
    public Maintenance ajouter(Maintenance maintenance) {
        return maintenanceRepo.save(maintenance);
    }

    @Override
    public void supprimerMaintenance(long id) {
        maintenanceRepo.deleteById(id);
    }

    @Override
    public Maintenance recupererMaintenance(long id) {
        return maintenanceRepo.findById(id).orElse(null);
    }

    @Override
    public List<Maintenance> recupererMaintenances() {
        return maintenanceRepo.findAll();
    }

    @Override
    public Maintenance updateMaintenance(Maintenance m) {
        return maintenanceRepo.save(m);
    }
}