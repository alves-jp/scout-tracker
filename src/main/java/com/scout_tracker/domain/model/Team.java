package com.scout_tracker.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private String teamState;
    private String teamCity;
    private String teamCountry;
    private String teamLeague;

    @OneToMany(mappedBy = "playerTeam")
    private List<Player> players;
}
