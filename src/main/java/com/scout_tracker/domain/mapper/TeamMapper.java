package com.scout_tracker.domain.mapper;

import com.scout_tracker.domain.dto.TeamDTO;
import com.scout_tracker.domain.model.Country;
import com.scout_tracker.domain.model.Team;
import com.scout_tracker.domain.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    @Autowired
    private static CountryRepository countryRepository;

    public static TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();

        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());
        dto.setTeamLeague(team.getTeamLeague());
        dto.setTeamCountryId(team.getTeamCountry() != null ? team.getTeamCountry().getId() : null);

        return dto;
    }

    public static Team toEntity(TeamDTO dto) {
        Team team = new Team();

        team.setTeamName(dto.getTeamName());
        team.setTeamLeague(dto.getTeamLeague());


        if (dto.getTeamCountryId() != null) {
            Country country = countryRepository.findById(dto.getTeamCountryId())
                    .orElseThrow(() -> new RuntimeException("País não encontrado"));

            team.setTeamCountry(country);
        }

        return team;
    }
}
