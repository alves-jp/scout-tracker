package com.scout_tracker.Scout.Tracker.domain.dto;

import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {

    private Long id;
    private String teamName;
    private String teamState;
    private String teamCity;
    private String teamCountry;
    private String teamLeague;
    private List<String> playerNames;
}
