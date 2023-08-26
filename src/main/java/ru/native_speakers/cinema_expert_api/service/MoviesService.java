package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

public interface MoviesService {
    Movie findMovieByMovieId(long movieId) throws EntityNotFoundException;
    Movie findMovieByMovieTitle(String movieTitle) throws EntityNotFoundException;
    List<Movie> findMoviesByMoviesTitleContaining(String movieTitle, int pageSize, int page) throws EntityNotFoundException;
    List<Movie> findAllOrderByRating(int pageSize, int page) throws EntityNotFoundException;
    List<Movie> findTopByGenreName(String genreName, int pageSize, int page) throws EntityNotFoundException;
    List<Movie> findTopByGenreId(long genreId, int pageSize, int page) throws EntityNotFoundException;
    long getMoviesCount();
}
