package tn.esprit.autolocnayssenksissa.Service;

import tn.esprit.autolocnayssenksissa.domain.Client;
import java.util.List;

public interface IClientService {
    Client ajouter(Client client);
    void supprimerClient(int id);
    Client recupererClient(int id);
    List<Client> recupererClients();
    Client updateClient(Client c);
}
