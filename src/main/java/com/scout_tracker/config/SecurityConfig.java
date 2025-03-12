package com.scout_tracker.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.SecurityFilterChain;

public interface SecurityConfig {
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception;

    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception;
}
