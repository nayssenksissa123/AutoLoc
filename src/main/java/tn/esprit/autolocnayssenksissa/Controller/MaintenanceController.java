package tn.esprit.autolocnayssenksissa.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IMaintenanceService;
import tn.esprit.autolocnayssenksissa.domain.Maintenance;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
@Tag(name = "Maintenances", description = "CRUD des maintenances")
public class MaintenanceController {

    IMaintenanceService maintenanceService;

    @Operation(summary = "Lister toutes les maintenances")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Maintenance> getMaintenances() {
        return maintenanceService.recupererMaintenances();
    }

    @Operation(summary = "Récupérer une maintenance par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Maintenance trouvée"),
            @ApiResponse(responseCode = "404", description = "Maintenance introuvable", content = @Content)
    })
    @GetMapping("/{maintenance-id}")
    public Maintenance retrieveMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        return maintenanceService.recupererMaintenance(maintenanceId);
    }

    @Operation(summary = "Ajouter une maintenance")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Maintenance créée"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouter(maintenance);
    }

    @Operation(summary = "Supprimer une maintenance")
    @ApiResponse(responseCode = "204", description = "Maintenance supprimée")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{maintenance-id}")
    public void removeMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        maintenanceService.supprimerMaintenance(maintenanceId);
    }

    @Operation(summary = "Modifier une maintenance")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Maintenance modifiée"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Maintenance modifyMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(maintenance);
    }
}