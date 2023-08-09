package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviesServiceImplementation implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Override
    public Movie findMovieByMovieId(int movieId) throws EntityNotFoundException {
        Optional<Movie> optionalMovie = moviesRepository.findById(movieId);
        if (optionalMovie.isEmpty()) {
            throw new EntityNotFoundException("Movie with this id not found");
        }
        return optionalMovie.get();
    }

    @Override
    public Movie findMovieByMovieTitle(String movieTitle) throws EntityNotFoundException {
        Optional<Movie> optionalMovie = moviesRepository.findByTitle(movieTitle);
        if (optionalMovie.isEmpty()) {
            throw new EntityNotFoundException("Movie with this title not found");
        }
        return optionalMovie.get();
    }

    @Override
    public List<Movie> findMoviesByMoviesTitleContaining(String movieTitle) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findAllByTitleContaining(movieTitle);
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies not found");
        }
        return movies;
    }

    @Override
    public List<Movie> findAllOrderByRating(int count) {
        return moviesRepository.findByOrderByChartRatingDesc(count);
    }

    @Override
    public List<Movie> findTopByGenreName(int count, String genreName) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findByGenreName(genreName, count);
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies by this genre not found");
        }
        return movies;
    }

    @Override
    public List<Movie> findTopByGenreId(int count, int genreId) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findByGenreId(genreId, count);
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies by this genre id not found");
        }
        return movies;
    }
}
