package com.scout_tracker.domain.dto;

import com.scout_tracker.domain.model.PlayerStatus;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private Long id;
    private String playerName;
    private String playerNickname;
    private PlayerStatus playerStatus;
    private String playerBirthday;
    private Integer playerAge;
    private Long countryId;
    private Long teamId;
    private double playerHeight;
    private double playerWeight;
    private String playerPosition;
    private int jerseyNumber;
}
