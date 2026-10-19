package tn.esprit.autolocnayssenksissa.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IVehiculeService;
import tn.esprit.autolocnayssenksissa.domain.Vehicule;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
@Tag(name = "Véhicules", description = "CRUD des véhicules")
public class VehiculeController {

    IVehiculeService vehiculeService;

    @Operation(summary = "Lister tous les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Vehicule> getVehicules() {
        return vehiculeService.recupererVehicules();
    }

    @Operation(summary = "Récupérer un véhicule par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @GetMapping("/{vehicule-id}")
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        return vehiculeService.recupererVehicule(vehiculeId);
    }

    @Operation(summary = "Ajouter un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Véhicule créé"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouter(vehicule);
    }

    @Operation(summary = "Supprimer un véhicule")
    @ApiResponse(responseCode = "204", description = "Véhicule supprimé")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        vehiculeService.supprimerVehicule(vehiculeId);
    }

    @Operation(summary = "Modifier un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Vehicule modifyVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.updateVehicule(vehicule);
    }
}