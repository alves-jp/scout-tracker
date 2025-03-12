package com.scout_tracker.domain.service.impl;

import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.mapper.PlayerMapper;
import com.scout_tracker.domain.model.Player;
import com.scout_tracker.domain.repository.PlayerRepository;
import com.scout_tracker.domain.service.PlayerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final FootballApiSyncServiceImpl footballApiSyncService;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper, FootballApiSyncServiceImpl footballApiSyncService) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.footballApiSyncService = footballApiSyncService;
    }

    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        player = playerRepository.save(player);

        return playerMapper.toDTO(player);
    }

    public PlayerDTO getPlayerById(Long id) {
        Optional<Player> playerOpt = playerRepository.findById(id);

        if (playerOpt.isPresent()) {
            return playerMapper.toDTO(playerOpt.get());

        } else {
            throw new RuntimeException("Jogador não encontrado");
        }
    }

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public List<PlayerDTO> getPlayersByScoutId(Long scoutId) {
        List<Player> players = playerRepository.findByScoutId(scoutId);
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public List<PlayerDTO> getPlayersByName(String playerName) {
        List<Player> players = playerRepository.findByPlayerNameContainingIgnoreCase(playerName);
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public List<PlayerDTO> getPlayersByPosition(String playerPosition) {
        List<Player> players = playerRepository.findByPlayerPositionIgnoreCase(playerPosition);
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public List<PlayerDTO> getPlayersByAgeRange(int minAge, int maxAge) {
        List<Player> players = playerRepository.findByPlayerAgeBetween(minAge, maxAge);
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public List<PlayerDTO> getPlayersByTeam(Long teamId) {
        List<Player> players = playerRepository.findByPlayerTeamId(teamId);
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public List<PlayerDTO> getPlayersByCountry(Long countryId) {
        List<Player> players = playerRepository.findByPlayerCountryId(countryId);
        return players.stream().map(playerMapper::toDTO).toList();
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Optional<Player> playerOpt = playerRepository.findById(id);

        if (playerOpt.isPresent()) {
            Player player = playerOpt.get();
            player.setPlayerName(playerDTO.getPlayerName());
            player.setPlayerNickname(playerDTO.getPlayerNickname());
            player.setPlayerStatus(playerDTO.getPlayerStatus());
            player.setPlayerBirthday(LocalDate.parse(playerDTO.getPlayerBirthday()));
            player.setPlayerAge(playerDTO.getPlayerAge());
            player.setPlayerHeight(playerDTO.getPlayerHeight());
            player.setPlayerWeight(playerDTO.getPlayerWeight());
            player.setPlayerPosition(playerDTO.getPlayerPosition());
            player.setJerseyNumber(playerDTO.getJerseyNumber());

            playerRepository.save(player);

            return playerMapper.toDTO(player);

        } else {
            throw new RuntimeException("Jogador não encontrado");
        }
    }

    public void deletePlayer(Long id) {
        Optional<Player> playerOpt = playerRepository.findById(id);

        if (playerOpt.isPresent()) {
            playerRepository.delete(playerOpt.get());

        } else {
            throw new RuntimeException("Jogador não encontrado");
        }
    }

    public void syncPlayerData(Long playerId) {
        footballApiSyncService.syncPlayerData(playerId);
    }
}