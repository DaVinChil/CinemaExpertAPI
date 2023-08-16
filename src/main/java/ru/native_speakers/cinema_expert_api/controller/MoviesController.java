package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

@RequestMapping("/movies")
@Validated
public interface MoviesController {

    @GetMapping("/{movieId}")
    HttpEntityResponse<MovieDTO> getMovieByMovieId(@PathVariable("movieId")
                                                   @Min(value = 1, message = "Movie id cannot be less that 1")
                                                   int movieId);

    @GetMapping("/find-by-title/{title}")
    HttpEntityResponse<MovieDTO> getMovieByMovieTitle(@PathVariable(name = "title") String movieTitle);

    @GetMapping("/find-by-title-containing/{title}")
    HttpEntityResponse<MovieDTO> getMoviesByMoviesTitleContaining(@PathVariable(name = "title") String movieTitle);

    @GetMapping("/top-rated")
    HttpEntityResponse<MovieDTO> getTopRatedMovies(@RequestParam(name = "count", defaultValue = "100")
                                                   @Min(value = 1, message = "Parameter 'count' cannot be less than 1")
                                                   int count);

    @GetMapping("/top-by-genre-name/{genre}")
    HttpEntityResponse<MovieDTO> getTopMoviesByGenreName(@PathVariable(name = "genre") String genre,
                                       @RequestParam(name = "count", defaultValue = "100")
                                       @Min(value = 1, message = "Parameter 'count' cannot be less than 1")
                                       int count);

    @GetMapping("/top-by-genre-id/{id}")
    HttpEntityResponse<MovieDTO> getTopMoviesByGenreId(@PathVariable(name = "id")
                                                       @Min(value = 1, message = "Genre id cannot be less than 1")
                                                       int genreId,
                                                       @RequestParam(name = "count", defaultValue = "100")
                                                       @Min(value = 1, message = "Parameter 'count' cannot be less than 1")
                                                       int count);

    @GetMapping("/{movieId}/directors")
    HttpEntityResponse<PersonDTO> getDirectorsByMovieId(@PathVariable("movieId")
                                                        @Min(value = 1, message = "Movie id cannot be less than 1")
                                                        int movieId);

    @GetMapping("/{movieId}/writers")
    HttpEntityResponse<PersonDTO> getWritersByMovieId(@PathVariable("movieId")
                                                      @Min(value = 1, message = "Movie id cannot be less than 1")
                                                      int movieId);

    @GetMapping("/{movieId}/actors")
    HttpEntityResponse<PersonDTO> getActorsByMovieId(@PathVariable("movieId")
                                                     @Min(value = 1, message = "Movie id cannot be less than 1")
                                                     int movieId);

    MovieDTO convertMovieToMovieDTO(Movie movie);
    List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies);
}
