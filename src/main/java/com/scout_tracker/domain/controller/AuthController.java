package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.dto.AuthDTO;
import com.scout_tracker.domain.dto.AuthResponseDTO;
import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> signup(@RequestBody ScoutDTO scoutDTO) {
        AuthResponseDTO response = authService.registerUser(scoutDTO);

        if ("success".equals(response.getMessage())) {
            return ResponseEntity.ok(response);

        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthDTO authDTO) {
        AuthResponseDTO response = authService.loginUser(authDTO);

        if ("success".equals(response.getMessage())) {
            return ResponseEntity.ok(response);

        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
