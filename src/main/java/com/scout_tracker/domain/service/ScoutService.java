package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.model.Scout;

import java.util.List;

public interface ScoutService {
    ScoutDTO saveScout(ScoutDTO dto);

    ScoutDTO getScoutById(Long id);

    List<ScoutDTO> getAllScouts();

    ScoutDTO updateScout(Long id, ScoutDTO dto);

    Scout findByUsername(String username);

    void deleteScout(Long id);


}

