package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.TeamDTO;

import java.util.List;

public interface TeamService {
    TeamDTO saveTeam(TeamDTO dto);
    TeamDTO getTeamById(Long id);
    List<TeamDTO> getAllTeams();
    TeamDTO updateTeam(Long id, TeamDTO dto);
    void deleteTeam(Long id);
}
