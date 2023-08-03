package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.service.MoviesService;
import java.util.List;

@RestController
public class MoviesRestControllerImplementation implements MoviesController {

    private final MoviesService moviesService;

    public MoviesRestControllerImplementation(@Qualifier(value = "moviesServiceImplementation") MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public List<MovieDTO> getTopRatedMovies(String count) {
        if (count != null) {
            return moviesService.convertMovieToMovieDTO(moviesService.findAllOrderByRating(Integer.parseInt(count)));
        }
        return moviesService.convertMovieToMovieDTO(moviesService.findAllOrderByRating());
    }

    @Override
    public List<MovieDTO> getTopMoviesByGenre(String count, String genre) {
        return null;
    }

    @Override
    public List<PersonDTO> getDirectorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<PersonDTO> getWritersByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<PersonDTO> getActorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return null;
    }
}
