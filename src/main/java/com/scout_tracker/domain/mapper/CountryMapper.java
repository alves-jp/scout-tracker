package com.scout_tracker.domain.mapper;

import com.scout_tracker.domain.dto.CountryDTO;
import com.scout_tracker.domain.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public static CountryDTO toDTO(Country country) {
        CountryDTO dto = new CountryDTO();

        dto.setId(country.getId());
        dto.setCountryName(country.getCountryName());
        dto.setCountryContinent(country.getCountryContinent());

        return dto;
    }

    public static Country toEntity(CountryDTO dto) {
        Country country = new Country();

        country.setCountryName(dto.getCountryName());
        country.setCountryContinent(dto.getCountryContinent());

        return country;
    }
}