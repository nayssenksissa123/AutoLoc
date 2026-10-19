package tn.esprit.autolocnayssenksissa.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocnayssenksissa.Repository.ClientRepository;
import tn.esprit.autolocnayssenksissa.domain.Client;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepo;

    @Override
    public Client ajouter(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public void supprimerClient(Long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Client recupererClient(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public List<Client> recupererClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepo.save(c);
    }
}