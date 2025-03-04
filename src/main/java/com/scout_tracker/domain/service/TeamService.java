package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.TeamDTO;
import com.scout_tracker.domain.exception.ResourceNotFoundException;
import com.scout_tracker.domain.mapper.TeamMapper;
import com.scout_tracker.domain.model.Team;
import com.scout_tracker.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;


    public TeamDTO saveTeam(TeamDTO dto) {
        Team team = TeamMapper.toEntity(dto);
        team = teamRepository.save(team);

        return TeamMapper.toDTO(team);
    }

    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clube não encontrado"));

        return TeamMapper.toDTO(team);
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(TeamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TeamDTO updateTeam(Long id, TeamDTO dto) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clube não encontrado"));

        team.setTeamName(dto.getTeamName());
        team.setTeamLeague(dto.getTeamLeague());
        team.setTeamCountry(dto.getTeamCountry());
        team = teamRepository.save(team);

        return TeamMapper.toDTO(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}