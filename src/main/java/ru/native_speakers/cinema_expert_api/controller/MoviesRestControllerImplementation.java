package ru.native_speakers.cinema_expert_api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.service.MoviesService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviesRestControllerImplementation implements MoviesController {

    private final MoviesService moviesService;
    private final ModelMapper modelMapper;

    public MoviesRestControllerImplementation(@Qualifier(value = "moviesServiceImp") MoviesService moviesService,
                                              ModelMapper modelMapper) {
        this.moviesService = moviesService;
        this.modelMapper = modelMapper;
    }

    @Override
    public HttpEntityResponse<MovieDTO> getMovieByMovieId(int movieId) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMovieByMovieId(movieId)));
    }

    @Override
    public HttpEntityResponse<MovieDTO> getMovieByMovieTitle(String movieTitle) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMovieByMovieTitle(movieTitle)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> getMoviesByMoviesTitleContaining(String movieTitle, int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findMoviesByMoviesTitleContaining(movieTitle, pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> getTopRatedMovies(int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findAllOrderByRating(pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> getTopMoviesByGenreName(String genre, int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findTopByGenreName(genre, pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<MovieDTO>> getTopMoviesByGenreId(int genreId, int pageSize, int page) {
        return new HttpEntityResponse<>(convertMovieToMovieDTO(moviesService.findTopByGenreId(genreId, pageSize, page)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getDirectorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getWritersByMovieId(int movieId) {
        return null;
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getActorsByMovieId(int movieId) {
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
}
