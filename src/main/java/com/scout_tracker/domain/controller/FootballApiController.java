package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.service.FootballApiSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/api/football")
public class FootballApiController {

    private final FootballApiSyncService footballApiSyncService;

    public FootballApiController(FootballApiSyncService footballApiSyncService) {
        this.footballApiSyncService = footballApiSyncService;
    }

    @PostMapping("/sync/{playerId}")
    public ResponseEntity<String> syncPlayer(@PathVariable Long playerId) {
        try {
            footballApiSyncService.syncPlayerData(playerId);
            return ResponseEntity.ok("Jogador sincronizado com sucesso!");

        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Erro ao sincronizar jogador: " + e.getMessage());
        }
    }
}
