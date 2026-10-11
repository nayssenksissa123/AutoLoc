package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.EquipementRepository;
import tn.esprit.autolocnayssenksissa.domain.Equipement;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementService implements IEquipementService {

    private final EquipementRepository equipementRepo;

    @Override
    public Equipement ajouter(Equipement equipement) {
        return equipementRepo.save(equipement);
    }

    @Override
    public void supprimerEquipement(long id) {
        equipementRepo.deleteById(id);
    }

    @Override
    public Equipement recupererEquipement(long id) {
        return equipementRepo.findById(id).orElse(null);
    }

    @Override
    public List<Equipement> recupererEquipements() {
        return equipementRepo.findAll();
    }

    @Override
    public Equipement updateEquipement(Equipement e) {
        return equipementRepo.save(e);
    }
}