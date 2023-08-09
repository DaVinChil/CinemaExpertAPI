package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.util.movie.MovieNotFoundException;
import java.util.List;

@RequestMapping("/movies")
public interface MoviesController {

    @GetMapping("/{movieId}")
    HttpEntityResponse<MovieDTO> getMovieByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/find-by-title")
    HttpEntityResponse<MovieDTO> getMovieByMovieTitle(@RequestParam(name = "title") String movieTitle);

    @GetMapping("/find-by-title-containing")
    HttpEntityResponse<MovieDTO> getMoviesByMoviesTitleContaining(@RequestParam(name = "title") String movieTitle);

    @GetMapping("/top-rated")
    HttpEntityResponse<MovieDTO> getTopRatedMovies(@RequestParam(name = "count", defaultValue = "100") int count);

    @GetMapping("/top-by-genre-name")
    HttpEntityResponse<MovieDTO> getTopMoviesByGenreName(@RequestParam(name = "count", defaultValue = "100") int count,
                                       @RequestParam(name = "genre") String genre);

    @GetMapping("/top-by-genre-id")
    HttpEntityResponse<MovieDTO> getTopMoviesByGenreId(@RequestParam(name = "count", defaultValue = "100") int count,
                                           @RequestParam(name = "genre") int genre);

    @GetMapping("/{movieId}/directors")
    HttpEntityResponse<PersonDTO> getDirectorsByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/{movieId}/writers")
    HttpEntityResponse<PersonDTO> getWritersByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/{movieId}/actors")
    HttpEntityResponse<PersonDTO> getActorsByMovieId(@PathVariable("movieId") int movieId);

    MovieDTO convertMovieToMovieDTO(Movie movie);
    List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies);

    @ExceptionHandler(value = MovieNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    HttpEntityExceptionResponse handleMovieNotFoundException(MovieNotFoundException e);
}
