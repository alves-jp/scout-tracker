package com.scout_tracker.domain.repository;

import com.scout_tracker.domain.model.ScoutObservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoutObservationRepository extends JpaRepository<ScoutObservation, Long> {

    List<ScoutObservation> findByPlayerId(Long playerId);

    List<ScoutObservation> findByScoutId(Long scoutId);
}