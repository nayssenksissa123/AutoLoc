package tn.esprit.autolocnayssenksissa.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autolocnayssenksissa.Repository.*;
import tn.esprit.autolocnayssenksissa.domain.*;

@Service
@RequiredArgsConstructor
public class AffectationService implements IAffectationService {

    private final VehiculeRepository vehiculeRepo;
    private final AgenceRepository agenceRepo;
    private final ContratRepository contratRepo;
    private final ReservationRepository reservationRepo;
    private final EquipementRepository equipementRepo;
    private final ClientRepository clientRepo;
    private final PaiementRepository paiementRepo;

    @Override
    @Transactional
    public void affecterVehiculeAAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + idVehicule));
        Agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
        vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional
    public void desaffecterVehiculeDAgence(Long idVehicule) {
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + idVehicule));
        vehicule.setAgence(null);
        vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional
    public void affecterContratAReservation(Long idContrat, Long idReservation) {
        Contrat contrat = contratRepo.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));
        Reservation reservation = reservationRepo.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + idReservation));
        contrat.setReservation(reservation);
        contratRepo.save(contrat);
    }

    @Override
    @Transactional
    public void desaffecterContratDeReservation(Long idReservation) {
        Reservation reservation = reservationRepo.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + idReservation));
        Contrat contrat = reservation.getContrat();
        if (contrat != null) {
            contrat.setReservation(null);
            reservation.setContrat(null);
            contratRepo.save(contrat);
        }
    }

    @Override
    @Transactional
    public void affecterEquipementAVehicule(Long idEquipement, Long idVehicule) {
        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + idEquipement));
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + idVehicule));
        vehicule.getEquipements().add(equipement);
        vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional
    public void desaffecterEquipementDeVehicule(Long idEquipement, Long idVehicule) {
        Equipement equipement = equipementRepo.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + idEquipement));
        Vehicule vehicule = vehiculeRepo.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + idVehicule));
        vehicule.getEquipements().remove(equipement);
        vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional
    public void affecterClientAReservation(Long idClient, Long idReservation) {
        Client client = clientRepo.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + idClient));
        Reservation reservation = reservationRepo.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + idReservation));
        reservation.setClient(client);
        reservationRepo.save(reservation);
    }

    @Override
    @Transactional
    public void affecterPaiementAContrat(Long idPaiement, Long idContrat) {
        Paiement paiement = paiementRepo.findById(idPaiement)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + idPaiement));
        Contrat contrat = contratRepo.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));
        paiement.setContrat(contrat);
        paiementRepo.save(paiement);
    }
}