package com.scout_tracker.domain.service.impl;

import com.scout_tracker.domain.dto.CountryDTO;
import com.scout_tracker.domain.exception.ResourceNotFoundException;
import com.scout_tracker.domain.mapper.CountryMapper;
import com.scout_tracker.domain.model.Country;
import com.scout_tracker.domain.repository.CountryRepository;
import com.scout_tracker.domain.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public CountryDTO saveCountry(CountryDTO dto) {
        Country country = CountryMapper.toEntity(dto);
        country = countryRepository.save(country);

        return CountryMapper.toDTO(country);
    }

    public CountryDTO getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("País não encontrado"));

        return CountryMapper.toDTO(country);
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(CountryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CountryDTO updateCountry(Long id, CountryDTO dto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("País não encontrado"));

        country.setCountryName(dto.getCountryName());
        country.setCountryContinent(dto.getCountryContinent());
        country = countryRepository.save(country);

        return CountryMapper.toDTO(country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}