package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import java.util.List;

@RequestMapping("/movies")
public interface MoviesController {

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

    @GetMapping
    List<MovieDTO> getAllMovies();
}
