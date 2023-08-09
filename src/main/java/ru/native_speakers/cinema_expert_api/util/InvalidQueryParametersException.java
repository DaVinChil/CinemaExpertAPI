package ru.native_speakers.cinema_expert_api.util.genre;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidQueryParametersException extends RuntimeException {
    public InvalidQueryParametersException(String message) {
        super(message);
    }
}
