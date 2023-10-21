package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.service.MoviesService;

import java.util.List;

import static ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO.convertMovieToMovieDTO;
import static ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO.convertPersonToPersonDTO;

@RestController
public class MoviesRestControllerImplementation implements MoviesController {
    private final MoviesService moviesService;

    public MoviesRestControllerImplementation(@Qualifier("moviesServiceImpl") MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public HttpEntityResponse<MovieDTO> findMovieByMovieId(long movieId) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMovieByMovieId(movieId)));
    }

    @Override
    public HttpEntityResponse<MovieDTO> findMovieByMovieTitle(String movieTitle) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMovieByMovieTitle(movieTitle)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> findMoviesByMoviesTitleContaining(String movieTitle, int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMoviesByMoviesTitleContaining(movieTitle, pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> findTopRatedMovies(int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findAllOrderByRating(pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> findTopMoviesByGenreName(String genre, int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findTopByGenreName(genre, pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> findTopMoviesByGenreId(long genreId, int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findTopByGenreId(genreId, pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findDirectorsByMovieId(long movieId) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(moviesService.findDirectorsByMovieId(movieId)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findWritersByMovieId(long movieId) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(moviesService.findWritersByMovieId(movieId)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findActorsByMovieId(long movieId) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(moviesService.findActorsByMovieId(movieId)));
    }
}
