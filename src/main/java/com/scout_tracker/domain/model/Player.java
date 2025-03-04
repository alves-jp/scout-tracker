package com.scout_tracker.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private String playerNickname;

    @Enumerated(EnumType.STRING)
    private PlayerStatus playerStatus;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate playerBirthday;

    private Integer playerAge;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country playerCountry;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team playerTeam;

    private double playerHeight;
    private double playerWeight;
    private String playerPosition;
    private int jerseyNumber;

    @ManyToOne
    @JoinColumn(name = "scout_id")
    @JsonIgnore
    private Scout scout;
}
