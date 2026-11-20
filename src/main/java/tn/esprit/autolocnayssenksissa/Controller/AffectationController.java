package tn.esprit.autolocnayssenksissa.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IAffectationService;

@RestController
@RequestMapping("/affectation")
@RequiredArgsConstructor
public class AffectationController {

    private final IAffectationService affectationService;

    @PutMapping("/vehicule/{idVehicule}/agence/{idAgence}")
    public void affecterVehiculeAAgence(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        affectationService.affecterVehiculeAAgence(idVehicule, idAgence);
    }

    @PutMapping("/desaffecter-vehicule/{idVehicule}")
    public void desaffecterVehiculeDAgence(@PathVariable Long idVehicule) {
        affectationService.desaffecterVehiculeDAgence(idVehicule);
    }

    @PutMapping("/contrat/{idContrat}/reservation/{idReservation}")
    public void affecterContratAReservation(@PathVariable Long idContrat, @PathVariable Long idReservation) {
        affectationService.affecterContratAReservation(idContrat, idReservation);
    }

    @PutMapping("/desaffecter-contrat/{idReservation}")
    public void desaffecterContratDeReservation(@PathVariable Long idReservation) {
        affectationService.desaffecterContratDeReservation(idReservation);
    }

    @PutMapping("/equipement/{idEquipement}/vehicule/{idVehicule}")
    public void affecterEquipementAVehicule(@PathVariable Long idEquipement, @PathVariable Long idVehicule) {
        affectationService.affecterEquipementAVehicule(idEquipement, idVehicule);
    }

    @PutMapping("/desaffecter-equipement/{idEquipement}/vehicule/{idVehicule}")
    public void desaffecterEquipementDeVehicule(@PathVariable Long idEquipement, @PathVariable Long idVehicule) {
        affectationService.desaffecterEquipementDeVehicule(idEquipement, idVehicule);
    }

    @PutMapping("/client/{idClient}/reservation/{idReservation}")
    public void affecterClientAReservation(@PathVariable Long idClient, @PathVariable Long idReservation) {
        affectationService.affecterClientAReservation(idClient, idReservation);
    }

    @PutMapping("/paiement/{idPaiement}/contrat/{idContrat}")
    public void affecterPaiementAContrat(@PathVariable Long idPaiement, @PathVariable Long idContrat) {
        affectationService.affecterPaiementAContrat(idPaiement, idContrat);
    }
}