package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviesServiceImplementation implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Override
    public Optional<Movie> findMovieByMovieId(int movieId) {
        return moviesRepository.findById(movieId);
    }

    @Override
    public Optional<Movie> findMovieByMovieTitle(String movieTitle) {
        return moviesRepository.findByTitle(movieTitle);
    }

    @Override
    public List<Movie> findMoviesByMoviesTitleContaining(String movieTitle) {
        return moviesRepository.findAllByTitleContaining(movieTitle);
    }

    @Override
    public List<Movie> findAllOrderByRating(int count) {
        return moviesRepository.findByOrderByChartRatingDesc(count);
    }

    @Override
    public List<Movie> findTopByGenreName(int count, String genreName) {
        return moviesRepository.findByGenreName(genreName, count);
    }

    @Override
    public List<Movie> findTopByGenreId(int count, int genreId) {
        return moviesRepository.findByGenreId(genreId, count);
    }

    @Override
    public List<Person> findDirectorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<Person> findWritersByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<Person> findActorsByMovieId(int movieId) {
        return null;
    }
}
