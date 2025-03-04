package com.scout_tracker.Scout.Tracker.domain.repository;

import com.scout_tracker.Scout.Tracker.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerNameContainingIgnoreCase(String playerName);
}