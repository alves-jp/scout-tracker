package com.scout_tracker.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FootballApiClient {

    private static final String BASE_URL = "https://api-football-v1.p.rapidapi.com/v3/";
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    @Value("${API_KEY}")
    private String apiKey;

    public FootballApiClient(String apiKey) {
        this.client = new OkHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String getData(String endpoint) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + endpoint)
                .get()
                .addHeader("x-rapidapi-key", apiKey)
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na requisição: " + response.code() + " - " + response.message());
            }
            return response.body().string();
        }
    }

    public <T> T getData(String endpoint, Class<T> responseType) throws IOException {
        String jsonResponse = getData(endpoint);

        return objectMapper.readValue(jsonResponse, responseType);
    }
}
