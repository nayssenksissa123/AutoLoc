package tn.esprit.autolocnayssenksissa.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocnayssenksissa.Service.IEmployeService;
import tn.esprit.autolocnayssenksissa.domain.Employe;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
@Tag(name = "Employés", description = "CRUD des employés")
public class EmployeController {

    IEmployeService employeService;

    @Operation(summary = "Lister tous les employés")
    @ApiResponse(responseCode = "200", description = "Liste retournée")
    @GetMapping()
    public List<Employe> getEmployes() {
        return employeService.recupererEmployes();
    }

    @Operation(summary = "Récupérer un employé par id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employé trouvé"),
            @ApiResponse(responseCode = "404", description = "Employé introuvable", content = @Content)
    })
    @GetMapping("/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") Long employeId) {
        return employeService.recupererEmploye(employeId);
    }

    @Operation(summary = "Ajouter un employé")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employé créé"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.ajouter(employe);
    }

    @Operation(summary = "Supprimer un employé")
    @ApiResponse(responseCode = "204", description = "Employé supprimé")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long employeId) {
        employeService.supprimerEmploye(employeId);
    }

    @Operation(summary = "Modifier un employé")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employé modifié"),
            @ApiResponse(responseCode = "400", description = "Requête invalide", content = @Content)
    })
    @PutMapping()
    public Employe modifyEmploye(@RequestBody Employe employe) {
        return employeService.updateEmploye(employe);
    }
}