package com.scout_tracker.domain.service.impl;

import com.scout_tracker.domain.dto.AuthDTO;
import com.scout_tracker.domain.dto.AuthResponseDTO;
import com.scout_tracker.domain.dto.ScoutDTO;
import com.scout_tracker.domain.model.Role;
import com.scout_tracker.domain.model.Scout;
import com.scout_tracker.domain.service.AuthService;
import com.scout_tracker.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final ScoutServiceImpl scoutService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    public AuthServiceImpl(ScoutServiceImpl scoutService, PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtUtil jwtUtil) {

        this.scoutService = scoutService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDTO registerUser(ScoutDTO scoutDTO) {

        if (scoutService.findByUsername(scoutDTO.getScoutName()) != null) {
            return new AuthResponseDTO(null, "ERRO: Usuário já existe.");
        }

        ScoutDTO scout = new ScoutDTO();
        scout.setScoutName(scoutDTO.getScoutName());
        scout.setScoutUsername(scoutDTO.getScoutUsername());
        scout.setPassword(passwordEncoder.encode(scout.getPassword()));
        scout.setRole(Role.USER);

        scoutService.saveScout(scoutDTO);

        AuthDTO authDTO = new AuthDTO();
        authDTO.setUsername(scoutDTO.getScoutUsername());
        authDTO.setPassword(scoutDTO.getPassword());

        return loginUser(authDTO);
    }

    @Override
    public AuthResponseDTO loginUser(AuthDTO authDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword()));

            final String token = jwtUtil.generateToken(authDTO.getUsername());

            return new AuthResponseDTO(token, "success");

        } catch (BadCredentialsException e) {

            return new AuthResponseDTO(null, "ERRO: Usuário ou senha inválida.");
        }
    }
}