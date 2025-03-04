package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.TeamDTO;
import com.scout_tracker.Scout.Tracker.domain.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamDTO teamToTeamDTO(Team team);
}
