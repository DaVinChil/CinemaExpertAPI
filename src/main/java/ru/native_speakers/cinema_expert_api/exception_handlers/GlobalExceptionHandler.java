package ru.native_speakers.cinema_expert_api.exception_handlers;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.exception.RegistrationException;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private HttpEntityExceptionResponse handleEntityNotFoundException(EntityNotFoundException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder errorMessage = new StringBuilder();
        e.getConstraintViolations().forEach(constraintViolation -> errorMessage.append(constraintViolation.getMessage()).append(";"));
        return new HttpEntityExceptionResponse(errorMessage.toString(), Collections.emptyList());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
         StringBuilder errorMessage = new StringBuilder();
         e.getBindingResult().getFieldErrors().forEach(fieldError ->
             errorMessage.append(fieldError.getDefaultMessage()).append(";")
         );
         return new HttpEntityExceptionResponse(errorMessage.toString(), Collections.emptyList());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }

    @ExceptionHandler(value = RegistrationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleRegistrationException(RegistrationException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }

    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleAuthenticationException(AuthenticationException e) {
        return new HttpEntityExceptionResponse("Incorrect username or password", Collections.emptyList());
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private HttpEntityExceptionResponse handleUsernameNotFoundException(UsernameNotFoundException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }
}
