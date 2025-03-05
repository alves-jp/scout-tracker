package com.scout_tracker.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FootballPlayerResponseDTO {
    @JsonProperty("player")
    private PlayerResponse player;

    @Data
    public static class PlayerResponse {
        private Long id;
        private String name;
        private String firstname;
        private String lastname;
        private Integer age;
        private String height;
        private String weight;
        private String position;
    }
}