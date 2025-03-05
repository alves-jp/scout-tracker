package com.scout_tracker.domain.repository;

import com.scout_tracker.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerNameContainingIgnoreCase(String playerName);

    List<Player> findByPlayerPositionIgnoreCase(String playerPosition);

    List<Player> findByPlayerAgeBetween(int minAge, int maxAge);

    List<Player> findByPlayerTeamId(Long teamId);

    List<Player> findByPlayerCountryId(Long countryId);
}