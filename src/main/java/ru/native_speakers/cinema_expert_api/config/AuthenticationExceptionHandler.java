package ru.native_speakers.cinema_expert_api.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;
import ru.native_speakers.cinema_expert_api.exception.RegistrationException;

import java.util.Collections;

@RestControllerAdvice
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    private HttpEntityExceptionResponse handleAccessDeniedException(AccessDeniedException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleAuthenticationException(AuthenticationException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }

    @ExceptionHandler(value = RegistrationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleRegistrationException(RegistrationException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }
}
