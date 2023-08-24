package ru.native_speakers.cinema_expert_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;

import java.io.IOException;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class AccessDeniedExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (AccessDeniedException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().println(objectMapper.writeValueAsString(
                    new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList())
            ));
        }
    }
}
