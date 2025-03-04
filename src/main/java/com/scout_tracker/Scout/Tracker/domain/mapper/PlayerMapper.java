package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.PlayerDTO;
import com.scout_tracker.Scout.Tracker.domain.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerDTO playerToPlayerDTO(Player player);
}
