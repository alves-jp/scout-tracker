package com.scout_tracker.Scout.Tracker.domain.mapper;

import com.scout_tracker.Scout.Tracker.domain.dto.CountryDTO;
import com.scout_tracker.Scout.Tracker.domain.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    CountryDTO countryToCountryDTO(Country country);
}
