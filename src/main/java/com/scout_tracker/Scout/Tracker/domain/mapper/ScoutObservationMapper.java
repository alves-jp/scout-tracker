package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.ScoutObservationDTO;
import com.scout_tracker.Scout.Tracker.domain.model.ScoutObservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScoutObservationMapper {

    ScoutObservationMapper INSTANCE = Mappers.getMapper(ScoutObservationMapper.class);

    ScoutObservationDTO scoutObservationToScoutObservationDTO(ScoutObservation scoutObservation);
}
