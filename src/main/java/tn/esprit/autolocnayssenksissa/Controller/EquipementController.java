package tn.esprit.autolocnayssenksissa.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IEquipementService;
import tn.esprit.autolocnayssenksissa.domain.Equipement;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
@Tag(name = "Équipements", description = "CRUD des équipements")
public class EquipementController {

    IEquipementService equipementService;

    @Operation(summary = "Lister tous les équipements")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Equipement> getEquipements() {
        return equipementService.recupererEquipements();
    }

    @Operation(summary = "Récupérer un équipement par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Équipement trouvé"),
            @ApiResponse(responseCode = "404", description = "Équipement introuvable", content = @Content)
    })
    @GetMapping("/{equipement-id}")
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long equipementId) {
        return equipementService.recupererEquipement(equipementId);
    }

    @Operation(summary = "Ajouter un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Équipement créé"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouter(equipement);
    }

    @Operation(summary = "Supprimer un équipement")
    @ApiResponse(responseCode = "204", description = "Équipement supprimé")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{equipement-id}")
    public void removeEquipement(@PathVariable("equipement-id") Long equipementId) {
        equipementService.supprimerEquipement(equipementId);
    }

    @Operation(summary = "Modifier un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Équipement modifié"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Equipement modifyEquipement(@RequestBody Equipement equipement) {
        return equipementService.updateEquipement(equipement);
    }
}