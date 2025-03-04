package com.scout_tracker.domain.repository;

import com.scout_tracker.domain.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByCountryNameContainingIgnoreCase(String countryName);
}