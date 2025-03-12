package com.scout_tracker.domain.repository;

import com.scout_tracker.domain.model.Scout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, Long> {

    List<Scout> findByScoutNameContainingIgnoreCase(String scoutName);

    Scout save(Scout scout);

    Optional<Scout> findByUsername(String username);

    Optional<Scout> findById(Long id);
}
