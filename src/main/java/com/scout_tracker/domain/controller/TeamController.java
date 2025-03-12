package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.TeamDTO;
import com.scout_tracker.domain.service.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO saveTeam(@RequestBody TeamDTO teamDTO) {
        return teamService.saveTeam(teamDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDTO getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeamDTO updateTeam(@PathVariable Long id, @RequestBody TeamDTO teamDTO) {
        return teamService.updateTeam(id, teamDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}