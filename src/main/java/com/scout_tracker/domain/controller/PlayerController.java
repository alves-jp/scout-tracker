package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDTO savePlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.savePlayer(playerDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/scout/{scoutId}")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getPlayersByScout(@PathVariable Long scoutId) {
        return playerService.getPlayersByScoutId(scoutId);
    }

    @GetMapping("/search/name")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getPlayersByName(@RequestParam String name) {
        return playerService.getPlayersByName(name);
    }

    @GetMapping("/search/position")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getPlayersByPosition(@RequestParam String position) {
        return playerService.getPlayersByPosition(position);
    }

    @GetMapping("/search/age-range")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getPlayersByAgeRange(
            @RequestParam int minAge,
            @RequestParam int maxAge) {
        return playerService.getPlayersByAgeRange(minAge, maxAge);
    }

    @GetMapping("/search/team")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getPlayersByTeam(@RequestParam Long teamId) {
        return playerService.getPlayersByTeam(teamId);
    }

    @GetMapping("/search/country")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerDTO> getPlayersByCountry(@RequestParam Long countryId) {
        return playerService.getPlayersByCountry(countryId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDTO updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        return playerService.updatePlayer(id, playerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
