package com.scout_tracker.config;

import com.scout_tracker.domain.model.enums.Role;
import com.scout_tracker.domain.model.Scout;
import com.scout_tracker.domain.repository.ScoutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ScoutRepository scoutRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(ScoutRepository scoutRepository, PasswordEncoder passwordEncoder) {
        this.scoutRepository = scoutRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (scoutRepository.findByUsername("admin").isEmpty()) {

            Scout adminUser = new Scout();
            adminUser.setScoutName("Admin User");
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setRole(Role.ADMIN);

            scoutRepository.save(adminUser);
            System.out.println("Admin user created: username='admin', password='admin123'");
        }
    }
}