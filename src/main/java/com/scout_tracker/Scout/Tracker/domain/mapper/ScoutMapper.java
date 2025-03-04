package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.ScoutDTO;
import com.scout_tracker.Scout.Tracker.domain.model.Scout;
import org.springframework.stereotype.Component;

@Component
public class ScoutMapper {

    public ScoutDTO toDTO(Scout scout) {
        ScoutDTO dto = new ScoutDTO();

        dto.setId(scout.getId());
        dto.setScoutName(scout.getScoutName());
        dto.setEmail(scout.getEmail());

        return dto;
    }

    public Scout toEntity(ScoutDTO dto) {
        Scout scout = new Scout();

        scout.setScoutName(dto.getScoutName());
        scout.setEmail(dto.getEmail());

        return scout;
    }
}