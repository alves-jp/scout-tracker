package com.scout_tracker.domain.controller;

import com.scout_tracker.domain.model.Scout;
import com.scout_tracker.domain.repository.ScoutRepository;
import com.scout_tracker.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final ScoutRepository scoutRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(JwtUtil jwtUtil, ScoutRepository scoutRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.scoutRepository = scoutRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Buscando usuário: " + username);
        Scout user = scoutRepository.findByUsername(username).orElse(null);

        if (user != null) {
            System.out.println("Usuário encontrado: " + user.getUsername());

            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = jwtUtil.generateToken(username);

                return ResponseEntity.ok().body(Map.of(
                        "token", token,
                        "message", "Authentication successful"
                ));

            } else {
                System.out.println("Senha inválida para o usuário: " + username);

            }
        } else {
            System.out.println("Usuário não encontrado");

        }

        return ResponseEntity.status(401).body(Map.of(
                "message", "Unauthorized"
        ));
    }
}
