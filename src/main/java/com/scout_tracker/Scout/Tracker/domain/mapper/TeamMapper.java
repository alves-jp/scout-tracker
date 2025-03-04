package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.TeamDTO;
import com.scout_tracker.Scout.Tracker.domain.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();

        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());
        dto.setTeamLeague(team.getTeamLeague());
        dto.setTeamCountry(team.getTeamCountry());

        return dto;
    }

    public Team toEntity(TeamDTO dto) {
        Team team = new Team();

        team.setTeamName(dto.getTeamName());
        team.setTeamLeague(dto.getTeamLeague());
        team.setTeamCountry(dto.getTeamCountry());

        return team;
    }
}