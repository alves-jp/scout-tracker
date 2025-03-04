package com.scout_tracker.Scout.Tracker.domain.service;

import com.scout_tracker.Scout.Tracker.domain.dto.PlayerDTO;
import com.scout_tracker.Scout.Tracker.domain.mapper.PlayerMapper;
import com.scout_tracker.Scout.Tracker.domain.model.Player;
import com.scout_tracker.Scout.Tracker.domain.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public PlayerDTO savePlayer(PlayerDTO dto) {
        Player player = PlayerMapper.toEntity(dto);
        player = playerRepository.save(player);

        return PlayerMapper.toDTO(player);
    }

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
