package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.exception.ResourceNotFoundException;
import com.scout_tracker.domain.mapper.ScoutMapper;
import com.scout_tracker.domain.model.Scout;
import com.scout_tracker.domain.repository.ScoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoutService {

    @Autowired
    private ScoutRepository scoutRepository;

    public ScoutDTO saveScout(ScoutDTO dto) {
        Scout scout = ScoutMapper.toEntity(dto);
        scout = scoutRepository.save(scout);

        return ScoutMapper.toDTO(scout);
    }

    public ScoutDTO getScoutById(Long id) {
        Scout scout = scoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Olheiro não encontrado"));

        return ScoutMapper.toDTO(scout);
    }

    public List<ScoutDTO> getAllScouts() {
        return scoutRepository.findAll().stream()
                .map(ScoutMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ScoutDTO updateScout(Long id, ScoutDTO dto) {
        Scout scout = scoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Olheiro não encontrado"));

        scout.setScoutName(dto.getScoutName());
        scout.setEmail(dto.getEmail());
        scout = scoutRepository.save(scout);

        return ScoutMapper.toDTO(scout);
    }

    public void deleteScout(Long id) {
        scoutRepository.deleteById(id);
    }
}
