package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.ScoutObservationDTO;
import com.scout_tracker.domain.exception.ResourceNotFoundException;
import com.scout_tracker.domain.mapper.ScoutObservationMapper;
import com.scout_tracker.domain.model.ScoutObservation;
import com.scout_tracker.domain.repository.ScoutObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoutObservationService {

    @Autowired
    private ScoutObservationRepository observationRepository;


    public ScoutObservationDTO saveObservation(ScoutObservationDTO dto) {
        ScoutObservation observation = ScoutObservationMapper.toEntity(dto);
        observation = observationRepository.save(observation);

        return ScoutObservationMapper.toDTO(observation);
    }

    public ScoutObservationDTO getObservationById(Long id) {
        ScoutObservation observation = observationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anotação não encontrada"));

        return ScoutObservationMapper.toDTO(observation);
    }

    public List<ScoutObservationDTO> getAllObservations() {
        return observationRepository.findAll().stream()
                .map(ScoutObservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ScoutObservationDTO updateObservation(Long id, ScoutObservationDTO dto) {
        ScoutObservation observation = observationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Anotação não encontrada"));

        observation.setObservation(dto.getObservation());
        observation.setObservationDate(LocalDateTime.parse(dto.getObservationDate()));

        observation = observationRepository.save(observation);

        return ScoutObservationMapper.toDTO(observation);
    }

    public void deleteObservation(Long id) {
        observationRepository.deleteById(id);
    }
}