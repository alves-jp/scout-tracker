package com.scout_tracker.Scout.Tracker.domain.repository;

import com.scout_tracker.Scout.Tracker.domain.model.Scout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, Long> {

    List<Scout> findByScoutNameContainingIgnoreCase(String scoutName);
}