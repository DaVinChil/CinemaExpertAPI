package ru.native_speakers.cinema_expert_api.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;

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

}
