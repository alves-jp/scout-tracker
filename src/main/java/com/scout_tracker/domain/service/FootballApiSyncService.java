package com.scout_tracker.domain.service;

import com.scout_tracker.api.FootballApiClient;
import com.scout_tracker.domain.dto.FootballPlayerResponseDTO;
import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.exception.ApiCommunicationException;
import com.scout_tracker.domain.exception.ApiRateLimitExceededException;
import com.scout_tracker.domain.exception.ApiTimeoutException;
import com.scout_tracker.domain.mapper.PlayerMapper;
import com.scout_tracker.domain.model.Player;
import com.scout_tracker.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FootballApiSyncService {

    private final FootballApiClient footballApiClient;
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public FootballApiSyncService(FootballApiClient footballApiClient, PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.footballApiClient = footballApiClient;
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public void syncPlayerData(Long playerId) {
        try {
            FootballPlayerResponseDTO response = footballApiClient.getData("players?id=" + playerId, FootballPlayerResponseDTO.class);
            Player player = convertToPlayer(response);
            playerRepository.save(player);
        } catch (ApiTimeoutException | ApiRateLimitExceededException | ApiCommunicationException e) {
            throw e;
        } catch (IOException e) {
            throw new ApiCommunicationException("Erro ao sincronizar dados do jogador: " + e.getMessage());
        }
    }

    private Player convertToPlayer(FootballPlayerResponseDTO response) {
        Player player = new Player();
        player.setPlayerName(response.getPlayer().getName());
        player.setPlayerNickname(response.getPlayer().getFirstname() + " " + response.getPlayer().getLastname());
        player.setPlayerAge(response.getPlayer().getAge());
        player.setPlayerHeight(Double.parseDouble(response.getPlayer().getHeight()));
        player.setPlayerWeight(Double.parseDouble(response.getPlayer().getWeight()));
        player.setPlayerPosition(response.getPlayer().getPosition());
        return player;
    }
}
