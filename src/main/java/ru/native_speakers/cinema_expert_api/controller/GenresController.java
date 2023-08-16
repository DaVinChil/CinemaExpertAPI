package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.GenreDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.model.Genre;

import java.util.List;

@RequestMapping("/genres")
@Validated
public interface GenresController {

    @GetMapping
    HttpEntityResponse<GenreDTO> getGenres(@RequestParam(name = "count", defaultValue = "20")
                                           @Min(value = 1, message = "Parameter 'count' cannot be less than 1")
                                           int count);

    @GetMapping("/{genreId}")
    HttpEntityResponse<GenreDTO> getGenreById(@PathVariable("genreId")
                                              @Min(value = 1, message = "Genre id cannot be less than 1") int genreId);

    GenreDTO convertGenreToGenreDTO(Genre genre);
    List<GenreDTO> convertGenreToGenreDTO(List<Genre> genres);
}
