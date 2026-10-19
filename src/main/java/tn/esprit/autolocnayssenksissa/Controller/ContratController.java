package tn.esprit.autolocnayssenksissa.Controller;
 
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IContratService;
import tn.esprit.autolocnayssenksissa.domain.Contrat;
 
import java.util.List;
 
@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
@Tag(name = "Contrats", description = "CRUD des contrats")
public class ContratController {
 
    IContratService contratService;
 
    @Operation(summary = "Lister tous les contrats")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Contrat> getContrats() {
        return contratService.recupererContrats();
    }
 
    @Operation(summary = "Récupérer un contrat par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat trouvé"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable", content = @Content)
    })
    @GetMapping("/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.recupererContrat(contratId);
    }
 
    @Operation(summary = "Ajouter un contrat")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Contrat créé"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.ajouter(contrat);
    }
 
    @Operation(summary = "Supprimer un contrat")
    @ApiResponse(responseCode = "204", description = "Contrat supprimé")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.supprimerContrat(contratId);
    }
 
    @Operation(summary = "Modifier un contrat")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat modifié"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Contrat modifyContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }
}
 