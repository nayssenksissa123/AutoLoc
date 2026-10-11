package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.EmployeRepository;
import tn.esprit.autolocnayssenksissa.domain.Employe;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {

    private final EmployeRepository employeRepo;

    @Override
    public Employe ajouter(Employe employe) {
        return employeRepo.save(employe);
    }

    @Override
    public void supprimerEmploye(long id) {
        employeRepo.deleteById(id);
    }

    @Override
    public Employe recupererEmploye(long id) {
        return employeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Employe> recupererEmployes() {
        return employeRepo.findAll();
    }

    @Override
    public Employe updateEmploye(Employe e) {
        return employeRepo.save(e);
    }
}