package com.scout_tracker.domain.repository;

import com.scout_tracker.domain.dto.AuthDTO;
import com.scout_tracker.domain.dto.AuthResponseDTO;
import com.scout_tracker.domain.dto.ScoutDTO;

public interface AuthService {
    AuthResponseDTO registerUser(ScoutDTO scoutDTO);
    AuthResponseDTO loginUser(AuthDTO authDTO);
}
