package com.scout_tracker.Scout.Tracker.domain.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoutObservationDTO {

    private Long id;
    private String observation;
    private String observationDate;
    private Long playerId;
    private Long scoutId;

}
