package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

public interface MoviesService {
    Movie findMovieByMovieId(long movieId);
    Movie findMovieByMovieTitle(String movieTitle);
    List<Movie> findMoviesByMoviesTitleContaining(String movieTitle, int pageSize, int page);
    List<Movie> findAllOrderByRating(int pageSize, int page);
    List<Movie> findTopByGenreName(String genreName, int pageSize, int page);
    List<Movie> findTopByGenreId(long genreId, int pageSize, int page);
    long getMoviesCount();
}
