package com.scout_tracker.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Value("${API_KEY}")
    private String apiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Chave de API no header: " + request.getHeader("API_KEY"));
        System.out.println("Chave de API do .env: " + apiKey);

        String apiKeyFromRequest = request.getHeader("API_KEY");

        if (apiKeyFromRequest == null || !apiKeyFromRequest.equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            response.getWriter().write("Chave de API inválida ou ausente.");

            return;
        }

        filterChain.doFilter(request, response);
    }
}


