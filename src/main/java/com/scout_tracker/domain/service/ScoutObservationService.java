package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.ScoutObservationDTO;

import java.util.List;

public interface ScoutObservationService {
    ScoutObservationDTO saveObservation(ScoutObservationDTO dto);
    ScoutObservationDTO getObservationById(Long id);
    List<ScoutObservationDTO> getAllObservations();
    ScoutObservationDTO updateObservation(Long id, ScoutObservationDTO dto);
    void deleteObservation(Long id);
}
