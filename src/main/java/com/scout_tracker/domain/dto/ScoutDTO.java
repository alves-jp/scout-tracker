package com.scout_tracker.domain.dto;

import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoutDTO {

    private Long id;
    private String scoutName;
    private String email;

    private List<String> playerNames;

    private List<String> observationDescriptions;
}
