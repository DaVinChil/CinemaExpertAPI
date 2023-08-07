package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.util.movie.MovieNotFoundException;
import ru.native_speakers.cinema_expert_api.util.movie.MovieNotFoundResponse;
import java.util.List;

@RequestMapping("/movies")
public interface MoviesController {

    @GetMapping("/{movieId}")
    MovieDTO getMovieByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/find-by-title")
    MovieDTO getMovieByMovieTitle(@RequestParam(name = "title") String movieTitle);

    @GetMapping("/find-by-title-containing")
    List<MovieDTO> getMoviesByMoviesTitleContaining(@RequestParam(name = "title") String movieTitle);

    @GetMapping("/top-rated")
    List<MovieDTO> getTopRatedMovies(@RequestParam(name = "count", defaultValue = "100") int count);

    @GetMapping("/top-by-genre-name")
    List<MovieDTO> getTopMoviesByGenreName(@RequestParam(name = "count", defaultValue = "100") int count,
                                       @RequestParam(name = "genre") String genre);

    @GetMapping("/top-by-genre-id")
    List<MovieDTO> getTopMoviesByGenreId(@RequestParam(name = "count", defaultValue = "100") int count,
                                           @RequestParam(name = "genre") int genre);

    @GetMapping("/{movieId}/directors")
    List<PersonDTO> getDirectorsByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/{movieId}/writers")
    List<PersonDTO> getWritersByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/{movieId}/actors")
    List<PersonDTO> getActorsByMovieId(@PathVariable("movieId") int movieId);

    MovieDTO convertMovieToMovieDTO(Movie movie);
    List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies);

    @ExceptionHandler(value = MovieNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    MovieNotFoundResponse handleMovieNotFoundException(MovieNotFoundException e);
}
