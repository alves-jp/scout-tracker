package com.scout_tracker.Scout.Tracker.domain.repository;

import com.scout_tracker.Scout.Tracker.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByTeamNameContainingIgnoreCase(String teamName);
}