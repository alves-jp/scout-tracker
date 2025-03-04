package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.ScoutObservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/observations")
public class ScoutObservationController {

    @Autowired
    private com.scout_tracker.domain.service.ScoutObservationService observationService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScoutObservationDTO saveObservation(@RequestBody ScoutObservationDTO observationDTO) {
        return observationService.saveObservation(observationDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoutObservationDTO getObservationById(@PathVariable Long id) {
        return observationService.getObservationById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScoutObservationDTO> getAllObservations() {
        return observationService.getAllObservations();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoutObservationDTO updateObservation(@PathVariable Long id, @RequestBody ScoutObservationDTO observationDTO) {
        return observationService.updateObservation(id, observationDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteObservation(@PathVariable Long id) {
        observationService.deleteObservation(id);
    }
}
