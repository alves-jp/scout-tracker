package com.scout_tracker.domain.dto;

import com.scout_tracker.domain.model.Role;
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
    private String scoutUsername;
    private String password;
    private String email;
    private Role role;

    private List<String> playerNames;

    private List<String> observationDescriptions;
}
