package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.exception.ApiCommunicationException;
import com.scout_tracker.domain.exception.ApiRateLimitExceededException;
import com.scout_tracker.domain.exception.ApiTimeoutException;
import com.scout_tracker.domain.service.FootballApiSyncService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        } catch (ApiTimeoutException e) {
            return ResponseEntity.status(408).body("Timeout ao sincronizar jogador: " + e.getMessage());

        } catch (ApiRateLimitExceededException e) {
            return ResponseEntity.status(429).body("Limite de requisições excedido: " + e.getMessage());

        } catch (ApiCommunicationException e) {
            return ResponseEntity.status(500).body("Erro de comunicação ao sincronizar jogador: " + e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro inesperado ao sincronizar jogador: " + e.getMessage());

        }
    }
}