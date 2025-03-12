package com.scout_tracker.domain.service;

import com.scout_tracker.domain.dto.AuthDTO;
import com.scout_tracker.domain.dto.AuthResponseDTO;
import com.scout_tracker.domain.dto.ScoutDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthResponseDTO registerUser(ScoutDTO scoutDTO);
    AuthResponseDTO loginUser(AuthDTO authDTO);
}
