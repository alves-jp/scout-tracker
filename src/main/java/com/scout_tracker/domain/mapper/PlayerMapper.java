package com.scout_tracker.domain.mapper;

import com.scout_tracker.domain.dto.PlayerDTO;
import com.scout_tracker.domain.model.Player;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class PlayerMapper {

    public static PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();

        dto.setId(player.getId());
        dto.setPlayerName(player.getPlayerName());
        dto.setPlayerNickname(player.getPlayerNickname());
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

    public static Player toEntity(PlayerDTO dto) {
        Player player = new Player();

        player.setPlayerName(dto.getPlayerName());
        player.setPlayerNickname(dto.getPlayerNickname());
        player.setPlayerBirthday(LocalDate.parse(dto.getPlayerBirthday()));
        player.setPlayerAge(dto.getPlayerAge());
        player.setPlayerHeight(dto.getPlayerHeight());
        player.setPlayerWeight(dto.getPlayerWeight());
        player.setPlayerPosition(dto.getPlayerPosition());
        player.setJerseyNumber(dto.getJerseyNumber());

        return player;
    }
}