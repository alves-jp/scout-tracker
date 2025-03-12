package com.scout_tracker.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getApiKey() {
        String apiKey = dotenv.get("API_KEY");

        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException("Chave de API não encontrada no arquivo .env.");
        }

        return apiKey;
    }
}