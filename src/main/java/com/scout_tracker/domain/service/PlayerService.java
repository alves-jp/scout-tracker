package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO savePlayer(PlayerDTO playerDTO);
    PlayerDTO getPlayerById(Long id);
    List<PlayerDTO> getAllPlayers();
    List<PlayerDTO> getPlayersByScoutId(Long scoutId);
    List<PlayerDTO> getPlayersByName(String playerName);
    List<PlayerDTO> getPlayersByPosition(String playerPosition);
    List<PlayerDTO> getPlayersByAgeRange(int minAge, int maxAge);
    List<PlayerDTO> getPlayersByTeam(Long teamId);
    List<PlayerDTO> getPlayersByCountry(Long countryId);
    PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO);
    void deletePlayer(Long id);
    void syncPlayerData(Long playerId);
}
