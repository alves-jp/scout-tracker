package com.scout_tracker.domain.service;

import com.scout_tracker.api.FootballApiClient;
import com.scout_tracker.domain.dto.FootballPlayerResponseDTO;
import com.scout_tracker.domain.model.Player;
import com.scout_tracker.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class FootballApiSyncService {

    private final FootballApiClient footballApiClient;
    private final PlayerRepository playerRepository;


    public FootballApiSyncService(FootballApiClient footballApiClient, PlayerRepository playerRepository) {
        this.footballApiClient = footballApiClient;
        this.playerRepository = playerRepository;
    }

    public void syncPlayerData(Long playerId) throws IOException {
        FootballPlayerResponseDTO response = footballApiClient.getData("players?id=" + playerId, FootballPlayerResponseDTO.class);

        Player player = convertToPlayer(response);

        playerRepository.save(player);
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
