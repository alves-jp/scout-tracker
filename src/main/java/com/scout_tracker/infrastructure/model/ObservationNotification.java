package com.scout_tracker.infrastructure.model;

import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.dto.ScoutObservationDTO;

public record ObservationNotification(
        ScoutDTO observationAuthor,
        ScoutObservationDTO createdObservation
) {}
