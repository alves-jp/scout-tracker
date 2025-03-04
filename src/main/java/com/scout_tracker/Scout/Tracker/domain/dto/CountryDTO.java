package com.scout_tracker.Scout.Tracker.domain.dto;

import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private Long id;
    private String countryName;
    private String countryContinent;
    private List<String> playerNames;
}
