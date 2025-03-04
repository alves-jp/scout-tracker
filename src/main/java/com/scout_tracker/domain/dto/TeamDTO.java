package com.scout_tracker.domain.dto;

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
    private Long teamCountryId;
    private String teamLeague;
    private List<String> playerNames;
}
