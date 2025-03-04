package com.scout_tracker.domain.service;

import com.scout_tracker.domain.exception.ResourceNotFoundException;
import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.mapper.PlayerMapper;
import com.scout_tracker.domain.model.Player;
import com.scout_tracker.domain.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public PlayerDTO savePlayer(PlayerDTO dto) {
        Player player = playerMapper.toEntity(dto);
        player = playerRepository.save(player);

        return playerMapper.toDTO(player);
    }

    public PlayerDTO getPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador não encontrado"));

        return playerMapper.toDTO(player);
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO dto) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogador não encontrado"));

        player.setPlayerName(dto.getPlayerName());
        player.setPlayerNickname(dto.getPlayerNickname());
        player.setPlayerBirthday(LocalDate.parse(dto.getPlayerBirthday()));
        player.setPlayerAge(dto.getPlayerAge());
        player.setPlayerHeight(dto.getPlayerHeight());
        player.setPlayerWeight(dto.getPlayerWeight());
        player.setPlayerPosition(dto.getPlayerPosition());
        player.setJerseyNumber(dto.getJerseyNumber());
        player = playerRepository.save(player);

        return playerMapper.toDTO(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
