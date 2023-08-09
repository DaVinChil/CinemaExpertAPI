package ru.native_speakers.cinema_expert_api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityExceptionResponse;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.service.MoviesService;
import ru.native_speakers.cinema_expert_api.util.movie.MovieNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class MoviesRestControllerImplementation implements MoviesController {

    private final MoviesService moviesService;
    private final ModelMapper modelMapper;

    public MoviesRestControllerImplementation(@Qualifier(value = "moviesServiceImplementation") MoviesService moviesService,
                                              ModelMapper modelMapper) {
        this.moviesService = moviesService;
        this.modelMapper = modelMapper;
    }

    @Override
    public HttpEntityResponse<MovieDTO> getMovieByMovieId(int movieId) {
        Optional<Movie> movieOptional = moviesService.findMovieByMovieId(movieId);
        if (movieOptional.isPresent()) {
            return new HttpEntityResponse<>(convertMovieToMovieDTO(List.of(movieOptional.get())));
        } else {
            throw new MovieNotFoundException("Movie with this id not found");
        }
    }

    @Override
    public HttpEntityResponse<MovieDTO> getMovieByMovieTitle(String movieTitle) {
        Optional<Movie> movieOptional = moviesService.findMovieByMovieTitle(movieTitle);
        if (movieOptional.isPresent()) {
            return new HttpEntityResponse<>(convertMovieToMovieDTO(List.of(movieOptional.get())));
        } else {
            throw new MovieNotFoundException("Movie with this title not found");
        }
    }

    @Override
    public HttpEntityResponse<MovieDTO> getMoviesByMoviesTitleContaining(String movieTitle) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMoviesByMoviesTitleContaining(movieTitle)));
    }

    @Override
    public HttpEntityResponse<MovieDTO> getTopRatedMovies(int count) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findAllOrderByRating(count)));
    }

    @Override
    public HttpEntityResponse<MovieDTO> getTopMoviesByGenreName(int count, String genre) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findTopByGenreName(count, genre)));
    }

    @Override
    public HttpEntityResponse<MovieDTO> getTopMoviesByGenreId(int count, int genreId) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findTopByGenreId(count, genreId)));
    }

    @Override
    public HttpEntityResponse<PersonDTO> getDirectorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public HttpEntityResponse<PersonDTO> getWritersByMovieId(int movieId) {
        return null;
    }

    @Override
    public HttpEntityResponse<PersonDTO> getActorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public MovieDTO convertMovieToMovieDTO(Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        movie.getDirectors().forEach(director -> movieDTO.addDirectorId(director.getId()));
        movie.getWriters().forEach(writer -> movieDTO.addWriterId(writer.getId()));
        movie.getActors().forEach(actor -> movieDTO.addActorId(actor.getId()));
        movie.getCharacters().forEach(character -> movieDTO.addCharacterId(character.getId()));
        return movieDTO;
    }

    @Override
    public List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies) {
        List<MovieDTO> movieDTOS = new ArrayList<>();
        movies.forEach(movie -> movieDTOS.add(convertMovieToMovieDTO(movie)));
        return movieDTOS;
    }

    @Override
    public HttpEntityExceptionResponse handleMovieNotFoundException(MovieNotFoundException e) {
        return new HttpEntityExceptionResponse(e.getMessage(), Collections.emptyList());
    }
}
