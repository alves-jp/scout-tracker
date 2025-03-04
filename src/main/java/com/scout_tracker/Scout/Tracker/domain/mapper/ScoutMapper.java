package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.ScoutDTO;
import com.scout_tracker.Scout.Tracker.domain.model.Scout;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScoutMapper {

    ScoutMapper INSTANCE = Mappers.getMapper(ScoutMapper.class);

    ScoutDTO scoutToScoutDTO(Scout scout);
}
