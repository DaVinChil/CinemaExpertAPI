package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import java.util.List;
import java.util.Optional;

public interface MoviesService {
    Optional<Movie> findMovieByMovieId(int movieId);
    Optional<Movie> findMovieByMovieTitle(String movieTitle);
    List<Movie> findMoviesByMoviesTitleContaining(String movieTitle);
    List<Movie> findAllOrderByRating(int count);
    List<Movie> findTopByGenreName(int count, String genreName);
    List<Movie> findTopByGenreId(int count, int genreId);
    List<Person> findDirectorsByMovieId(int movieId);
    List<Person> findWritersByMovieId(int movieId);
    List<Person> findActorsByMovieId(int movieId);
}
