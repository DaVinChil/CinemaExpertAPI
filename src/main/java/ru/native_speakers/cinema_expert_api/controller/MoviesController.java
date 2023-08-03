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
    List<MovieDTO> getTopRatedMovies(@RequestParam(name = "count", required = false) String count);

    @GetMapping("/top-by-genre")
    List<MovieDTO> getTopMoviesByGenre(@RequestParam(name = "count", required = false) String count,
                                       @RequestParam(name = "genre") String genre);

    @GetMapping("/{movieId}/directors")
    List<PersonDTO> getDirectorsByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/{movieId}/writers")
    List<PersonDTO> getWritersByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping("/{movieId}/actors")
    List<PersonDTO> getActorsByMovieId(@PathVariable("movieId") int movieId);

    @GetMapping
    List<MovieDTO> getAllMovies();
}
