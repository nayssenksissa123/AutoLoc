package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.VehiculeRepository;
import tn.esprit.autolocnayssenksissa.domain.Vehicule;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeService implements IVehiculeService {

    private final VehiculeRepository vehiculeRepo;

    @Override
    public Vehicule ajouter(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @Override
    public void supprimerVehicule(long id) {
        vehiculeRepo.deleteById(id);
    }

    @Override
    public Vehicule recupererVehicule(long id) {
        return vehiculeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Vehicule> recupererVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    public Vehicule updateVehicule(Vehicule v) {
        return vehiculeRepo.save(v);
    }
}