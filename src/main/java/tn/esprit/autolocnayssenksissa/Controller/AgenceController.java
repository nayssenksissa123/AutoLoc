package tn.esprit.autolocnayssenksissa.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IAgenceService;
import tn.esprit.autolocnayssenksissa.domain.Agence;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
@Tag(name = "Agences", description = "CRUD des agences")
public class AgenceController {

    IAgenceService agenceService;

    @Operation(summary = "Lister toutes les agences")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Agence> getAgences() {
        return agenceService.recupererAgences();
    }

    @Operation(summary = "Récupérer une agence par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @GetMapping("/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") long agenceId) {
        return agenceService.recupererAgence(agenceId);
    }

    @Operation(summary = "Ajouter une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Agence créée"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.ajouter(agence);
    }

    @Operation(summary = "Supprimer une agence")
    @ApiResponse(responseCode = "204", description = "Agence supprimée")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") long agenceId) {
        agenceService.supprimerAgence(agenceId);
    }

    @Operation(summary = "Modifier une agence")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Agence modifyAgence(@RequestBody Agence agence) {
        return agenceService.updateAgence(agence);
    }
}