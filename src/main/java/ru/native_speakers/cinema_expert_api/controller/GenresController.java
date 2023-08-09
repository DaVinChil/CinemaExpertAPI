package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.GenreDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.model.Genre;
import ru.native_speakers.cinema_expert_api.util.genre.GenreNotFoundException;
import ru.native_speakers.cinema_expert_api.util.genre.InvalidQueryParametersException;
import java.util.List;

@RequestMapping("/genres")
public interface GenresController {

    @GetMapping
    HttpEntityResponse<GenreDTO> getGenres(@RequestParam(name = "count", defaultValue = "20") int count);

    @GetMapping("/{genreId}")
    HttpEntityResponse<GenreDTO> getGenreById(@PathVariable("genreId") int genreId);

    GenreDTO convertGenreToGenreDTO(Genre genre);
    List<GenreDTO> convertGenreToGenreDTO(List<Genre> genres);

    @ExceptionHandler(value = GenreNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    HttpEntityExceptionResponse handleGenreNotFoundException(GenreNotFoundException e);

    @ExceptionHandler(value = InvalidQueryParametersException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    HttpEntityExceptionResponse handleInvalidQueryParametersException(InvalidQueryParametersException e);
}
