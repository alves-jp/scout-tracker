package com.scout_tracker.domain.mapper;

import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.model.Player;
import com.scout_tracker.domain.model.Country;
import com.scout_tracker.domain.model.Team;
import com.scout_tracker.domain.repository.CountryRepository;
import com.scout_tracker.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class PlayerMapper {

    private final CountryRepository countryRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public PlayerMapper(CountryRepository countryRepository, TeamRepository teamRepository) {
        this.countryRepository = countryRepository;
        this.teamRepository = teamRepository;
    }

    public PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setPlayerName(player.getPlayerName());
        dto.setPlayerNickname(player.getPlayerNickname());
        dto.setPlayerStatus(player.getPlayerStatus());
        dto.setPlayerBirthday(player.getPlayerBirthday().toString());
        dto.setPlayerAge(player.getPlayerAge());
        dto.setPlayerHeight(player.getPlayerHeight());
        dto.setPlayerWeight(player.getPlayerWeight());
        dto.setPlayerPosition(player.getPlayerPosition());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setCountryId(player.getPlayerCountry().getId());
        dto.setTeamId(player.getPlayerTeam().getId());
        return dto;
    }

    public Player toEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setPlayerName(dto.getPlayerName());
        player.setPlayerNickname(dto.getPlayerNickname());
        player.setPlayerStatus(dto.getPlayerStatus());
        player.setPlayerBirthday(LocalDate.parse(dto.getPlayerBirthday()));
        player.setPlayerAge(dto.getPlayerAge());
        player.setPlayerHeight(dto.getPlayerHeight());
        player.setPlayerWeight(dto.getPlayerWeight());
        player.setPlayerPosition(dto.getPlayerPosition());
        player.setJerseyNumber(dto.getJerseyNumber());

        Country country = countryRepository.findById(dto.getCountryId())
                .orElseThrow(() -> new RuntimeException("País não encontrado"));
        player.setPlayerCountry(country);

        Team team = teamRepository.findById(dto.getTeamId())
                .orElseThrow(() -> new RuntimeException("Clube não encontrado"));
        player.setPlayerTeam(team);

        return player;
    }
}
