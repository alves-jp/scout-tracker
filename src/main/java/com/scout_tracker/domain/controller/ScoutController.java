package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.service.impl.ScoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scouts")
public class ScoutController {

    @Autowired
    private ScoutServiceImpl scoutService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScoutDTO saveScout(@RequestBody ScoutDTO scoutDTO) {
        return scoutService.saveScout(scoutDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoutDTO getScoutById(@PathVariable Long id) {
        return scoutService.getScoutById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScoutDTO> getAllScouts() {
        return scoutService.getAllScouts();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScoutDTO updateScout(@PathVariable Long id, @RequestBody ScoutDTO scoutDTO) {
        return scoutService.updateScout(id, scoutDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScout(@PathVariable Long id) {
        scoutService.deleteScout(id);
    }
}