package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import java.util.List;

public interface MoviesService {
    List<Movie> findAll();
    List<Movie> findAllOrderByRating(int count);
    List<Movie> findAllOrderByRating();
    List<Movie> findTopByGenreName(int count, String genreName);
    List<Movie> findTopByGenreId(int count, int genreId);
    List<Person> findDirectorsByMovieId(int movieId);
    List<Person> findWritersByMovieId(int movieId);
    List<Person> findActorsByMovieId(int movieId);
    MovieDTO convertMovieToMovieDTO(Movie movie);
    List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies);
    Movie convertMovieDTOToMovie(MovieDTO movieDTO);
    List<Movie> convertMovieDTOToMovie(List<MovieDTO> movieDTOS);
}
