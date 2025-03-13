package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.ScoutObservationDTO;
import com.scout_tracker.domain.service.impl.ScoutObservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;

@RestController
@RequestMapping("/observations")
@Tag(name = "Observations", description = "Gerenciamento de observações dos olheiros")
public class ScoutObservationController {

    @Autowired
    private ScoutObservationServiceImpl observationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar uma nova observação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Observação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    public ScoutObservationDTO saveObservation(@RequestBody(description = "Dados da nova observação")
                                                ScoutObservationDTO observationDTO) {
        return observationService.saveObservation(observationDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar uma observação por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Observação encontrada"),
            @ApiResponse(responseCode = "404", description = "Observação não encontrada")
    })
    public ScoutObservationDTO getObservationById(@PathVariable Long id) {
        return observationService.getObservationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar todas as observações")
    public List<ScoutObservationDTO> getAllObservations() {
        return observationService.getAllObservations();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar uma observação existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Observação atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Observação não encontrada")
    })
    public ScoutObservationDTO updateObservation(@PathVariable Long id,
                                                 @RequestBody(description = "Dados atualizados da observação")
                                                 ScoutObservationDTO observationDTO) {

        return observationService.updateObservation(id, observationDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar uma observação por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Observação deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Observação não encontrada")
    })
    public void deleteObservation(@PathVariable Long id) {
        observationService.deleteObservation(id);
    }
}
