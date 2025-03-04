package com.scout_tracker.domain.mapper;

import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.model.Scout;
import org.springframework.stereotype.Component;

@Component
public class ScoutMapper {

    public static ScoutDTO toDTO(Scout scout) {
        ScoutDTO dto = new ScoutDTO();

        dto.setId(scout.getId());
        dto.setScoutName(scout.getScoutName());
        dto.setEmail(scout.getEmail());

        return dto;
    }

    public static Scout toEntity(ScoutDTO dto) {
        Scout scout = new Scout();

        scout.setScoutName(dto.getScoutName());
        scout.setEmail(dto.getEmail());

        return scout;
    }
}