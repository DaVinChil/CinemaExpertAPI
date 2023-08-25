package ru.native_speakers.cinema_expert_api.exception_handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;

import java.io.IOException;
import java.util.Collections;

@RestControllerAdvice
@RequiredArgsConstructor
public class AuthenticationExceptionHandlerFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleAuthenticationException(AuthenticationException e) {
        return new HttpEntityExceptionResponse("Incorrect username or password", Collections.emptyList());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (AuthenticationException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().println(objectMapper.writeValueAsString(
                    new HttpEntityExceptionResponse("Incorrect username or password", Collections.emptyList())
            ));
        }
    }
}
