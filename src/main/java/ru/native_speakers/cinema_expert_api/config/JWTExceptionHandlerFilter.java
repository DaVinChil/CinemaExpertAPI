package ru.native_speakers.cinema_expert_api.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JWTExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        }  catch (JWTVerificationException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().println(objectMapper.writeValueAsString(
                    new HttpEntityExceptionResponse("Invalid JWT. Send your username and password to /auth/signup to register a new user and get JWT or" +
                            " to /auth/signin to obtain new JWT if you are already registered", Collections.emptyList()))
            );
        }
    }
}
