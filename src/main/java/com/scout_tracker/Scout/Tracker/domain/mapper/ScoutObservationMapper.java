package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.ScoutObservationDTO;
import com.scout_tracker.Scout.Tracker.domain.model.ScoutObservation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScoutObservationMapper {

    public ScoutObservationDTO toDTO(ScoutObservation observation) {
        ScoutObservationDTO dto = new ScoutObservationDTO();

        dto.setId(observation.getId());
        dto.setObservation(observation.getObservation());
        dto.setObservationDate(String.valueOf(observation.getObservationDate()));
        dto.setPlayerId(observation.getPlayer().getId());
        dto.setScoutId(observation.getScout().getId());

        return dto;
    }

    public ScoutObservation toEntity(ScoutObservationDTO dto) {
        ScoutObservation observation = new ScoutObservation();

        observation.setObservation(dto.getObservation());
        observation.setObservationDate(LocalDateTime.parse(dto.getObservationDate()));

        return observation;
    }
}