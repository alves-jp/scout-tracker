package com.scout_tracker.domain.event;

import com.scout_tracker.domain.model.PlayerStatus;
import org.springframework.core.convert.converter.Converter;

public class PlayerStatusConverter implements Converter<String, PlayerStatus> {
    @Override
    public PlayerStatus convert(String source) {
        return PlayerStatus.valueOf(source.toUpperCase());
    }
}