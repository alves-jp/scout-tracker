package com.scout_tracker.config;

import com.scout_tracker.api.FootballApiClient;
import com.scout_tracker.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public FootballApiClient footballApiClient() {
        String apiKey = System.getenv("API_KEY");
        return new FootballApiClient(apiKey);
    }
}