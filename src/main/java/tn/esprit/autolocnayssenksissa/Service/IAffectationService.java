package tn.esprit.autolocnayssenksissa.Service;

public interface IAffectationService {
    void affecterVehiculeAAgence(Long idVehicule, Long idAgence);
    void desaffecterVehiculeDAgence(Long idVehicule);
    void affecterContratAReservation(Long idContrat, Long idReservation);
    void desaffecterContratDeReservation(Long idReservation);
    void affecterEquipementAVehicule(Long idEquipement, Long idVehicule);
    void desaffecterEquipementDeVehicule(Long idEquipement, Long idVehicule);
    void affecterClientAReservation(Long idClient, Long idReservation);
    void affecterPaiementAContrat(Long idPaiement, Long idContrat);
}