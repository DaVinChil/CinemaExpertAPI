package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

public interface MoviesService {
    Movie findMovieByMovieId(int movieId);
    Movie findMovieByMovieTitle(String movieTitle);
    List<Movie> findMoviesByMoviesTitleContaining(String movieTitle);
    List<Movie> findAllOrderByRating(int count);
    List<Movie> findTopByGenreName(String genreName, int count);
    List<Movie> findTopByGenreId(int genreId, int count);
    long getMoviesCount();
}
