package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO saveCountry(CountryDTO dto);
    CountryDTO getCountryById(Long id);
    List<CountryDTO> getAllCountries();
    CountryDTO updateCountry(Long id, CountryDTO dto);
    void deleteCountry(Long id);
}
