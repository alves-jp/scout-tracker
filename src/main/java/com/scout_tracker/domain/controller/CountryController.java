package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.CountryDTO;
import com.scout_tracker.domain.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryServiceImpl countryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryDTO saveCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.saveCountry(countryDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CountryDTO getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CountryDTO updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        return countryService.updateCountry(id, countryDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
