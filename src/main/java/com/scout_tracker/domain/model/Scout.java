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
public class Scout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scoutName;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "scout", cascade = CascadeType.ALL)
    private List<Player> players;

    @OneToMany(mappedBy = "scout", cascade = CascadeType.ALL)
    private List<ScoutObservation> observations;

    @Enumerated(EnumType.STRING)
    private Role role;
}