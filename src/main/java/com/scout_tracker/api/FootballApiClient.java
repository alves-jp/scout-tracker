package com.scout_tracker.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scout_tracker.domain.exception.ApiCommunicationException;
import com.scout_tracker.domain.exception.ApiRateLimitExceededException;
import com.scout_tracker.domain.exception.ApiTimeoutException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class FootballApiClient {

    private static final Logger logger = LoggerFactory.getLogger(FootballApiClient.class);
    private static final String BASE_URL = "https://api-football-v1.p.rapidapi.com/v3/";
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    @Value("${API_KEY}")
    private String apiKey;

    public FootballApiClient(String apiKey) {
        this.client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

        this.objectMapper = new ObjectMapper();
    }

    @Retryable(
            value = {ApiTimeoutException.class, ApiRateLimitExceededException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 1000)
    )

    public <T> T getData(String endpoint, Class<T> responseType) throws IOException {
        try {
            String jsonResponse = getData(endpoint);
            return objectMapper.readValue(jsonResponse, responseType);

        } catch (IOException e) {
            logger.error("Erro de comunicação com a API externa: {}", e.getMessage());

            throw new ApiCommunicationException("Erro de comunicação com a API externa: " + e.getMessage());
        }
    }

    private String getData(String endpoint) throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL + endpoint)
                .get()
                .addHeader("x-rapidapi-key", apiKey)
                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                if (response.code() == 429) {
                    throw new ApiRateLimitExceededException("Limite de requisições excedido.");

                }
                throw new IOException("Erro na requisição: " + response.code() + " - " + response.message());

            }
            return response.body().string();

        } catch (IOException e) {
            logger.error("Erro ao chamar a API externa: {}", e.getMessage());
            throw e;
        }
    }
}
