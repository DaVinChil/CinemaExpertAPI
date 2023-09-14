package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;

import java.util.List;

@RequestMapping("/movies")
@Validated
public interface MoviesController {

    @GetMapping("/{movieId}")
    HttpEntityResponse<MovieDTO> findMovieByMovieId(
            @PathVariable("movieId")
            @Min(value = 1, message = "Movie id cannot be less that 1")
            long movieId
    );

    @GetMapping("/by-title/{title}")
    HttpEntityResponse<MovieDTO> findMovieByMovieTitle(@PathVariable(name = "title") String movieTitle);

    @GetMapping("/by-title-containing/{title}")
    HttpEntityResponse<List<MovieDTO>> findMoviesByMoviesTitleContaining(
            @PathVariable(name = "title") String movieTitle,
            @RequestParam(name = "page_size")
            @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
            @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
            int pageSize,
            @RequestParam(name = "page")
            @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
            int page
    );

    @GetMapping("/top-rated")
    HttpEntityResponse<List<MovieDTO>> findTopRatedMovies(
            @RequestParam(name = "page_size")
            @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
            @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
            int pageSize,
            @RequestParam(name = "page")
            @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
            int page
    );

    @GetMapping("/top-by-genre-name/{genre}")
    HttpEntityResponse<List<MovieDTO>> findTopMoviesByGenreName(
            @PathVariable(name = "genre") String genre,
            @RequestParam(name = "page_size")
            @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
            @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
            int pageSize,
            @RequestParam(name = "page")
            @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
            int page
    );

    @GetMapping("/top-by-genre-id/{id}")
    HttpEntityResponse<List<MovieDTO>> findTopMoviesByGenreId(
            @PathVariable(name = "id")
            @Min(value = 1, message = "Genre id cannot be less than 1")
            long genreId,
            @RequestParam(name = "page_size")
            @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
            @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
            int pageSize,
            @RequestParam(name = "page")
            @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
            int page
    );

    @GetMapping("/{movieId}/directors")
    HttpEntityResponse<List<PersonDTO>> findDirectorsByMovieId(
            @PathVariable("movieId")
            @Min(value = 1, message = "Movie id cannot be less than 1")
            long movieId
    );

    @GetMapping("/{movieId}/writers")
    HttpEntityResponse<List<PersonDTO>> findWritersByMovieId(
            @PathVariable("movieId")
            @Min(value = 1, message = "Movie id cannot be less than 1")
            long movieId
    );

    @GetMapping("/{movieId}/actors")
    HttpEntityResponse<List<PersonDTO>> findActorsByMovieId(
            @PathVariable("movieId")
            @Min(value = 1, message = "Movie id cannot be less than 1")
            long movieId
    );
}
