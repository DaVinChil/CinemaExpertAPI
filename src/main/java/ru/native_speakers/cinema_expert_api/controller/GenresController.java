package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Max;
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
    HttpEntityResponse<List<GenreDTO>> getGenres(@RequestParam(name = "page_size")
                                           @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                           @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
                                           int pageSize,
                                           @RequestParam(name = "page")
                                           @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                           int page);

    @GetMapping("/{genreId}")
    HttpEntityResponse<GenreDTO> getGenreById(@PathVariable("genreId")
                                              @Min(value = 1, message = "Genre id cannot be less than 1") int genreId);

    GenreDTO convertGenreToGenreDTO(Genre genre);
    List<GenreDTO> convertGenreToGenreDTO(List<Genre> genres);
}
