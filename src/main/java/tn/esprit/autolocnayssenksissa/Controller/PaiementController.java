package tn.esprit.autolocnayssenksissa.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IPaiementService;
import tn.esprit.autolocnayssenksissa.domain.Paiement;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
@Tag(name = "Paiements", description = "CRUD des paiements")
public class PaiementController {

    IPaiementService paiementService;

    @Operation(summary = "Lister tous les paiements")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Paiement> getPaiements() {
        return paiementService.recupererPaiements();
    }

    @Operation(summary = "Récupérer un paiement par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement trouvé"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable", content = @Content)
    })
    @GetMapping("/{paiement-id}")
    public Paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
        return paiementService.recupererPaiement(paiementId);
    }

    @Operation(summary = "Ajouter un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Paiement créé"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouter(paiement);
    }

    @Operation(summary = "Supprimer un paiement")
    @ApiResponse(responseCode = "204", description = "Paiement supprimé")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{paiement-id}")
    public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
        paiementService.supprimerPaiement(paiementId);
    }

    @Operation(summary = "Modifier un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement modifié"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Paiement modifyPaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }
}