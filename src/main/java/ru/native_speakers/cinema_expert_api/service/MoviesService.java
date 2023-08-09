package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

public interface MoviesService {
    Movie findMovieByMovieId(int movieId);
    Movie findMovieByMovieTitle(String movieTitle);
    List<Movie> findMoviesByMoviesTitleContaining(String movieTitle);
    List<Movie> findAllOrderByRating(int count);
    List<Movie> findTopByGenreName(int count, String genreName);
    List<Movie> findTopByGenreId(int count, int genreId);
}
