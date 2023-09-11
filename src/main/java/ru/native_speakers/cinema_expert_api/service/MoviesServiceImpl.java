package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;
import ru.native_speakers.cinema_expert_api.repository.PersonsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository moviesRepository;
    private final PersonsRepository personsRepository;

    @Override
    public Movie findMovieByMovieId(long movieId) throws EntityNotFoundException {
        return moviesRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("Movie with this id not found"));
    }

    @Override
    public Movie findMovieByMovieTitle(String movieTitle) throws EntityNotFoundException {
        return moviesRepository.findByTitle(movieTitle).orElseThrow(() -> new EntityNotFoundException("Movie with this title not found"));
    }

    @Override
    public List<Movie> findMoviesByMoviesTitleContaining(String movieTitle, int pageSize, int page) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findAllByTitleContaining(movieTitle, PageRequest.of(page, pageSize)).getContent();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies not found");
        }
        return movies;
    }

    @Override
    public List<Movie> findAllOrderByRating(int pageSize, int page) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findByOrderByChartRatingDesc(PageRequest.of(page, pageSize)).getContent();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies not found");
        }
        return movies;
    }

    @Override
    public List<Movie> findTopByGenreName(String genreName, int pageSize, int page) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findAllByGenreName(genreName, PageRequest.of(page, pageSize)).getContent();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies by this genre not found");
        }
        return movies;
    }

    @Override
    public List<Movie> findTopByGenreId(long genreId, int pageSize, int page) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findAllByGenreId(genreId, PageRequest.of(page, pageSize)).getContent();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies by this genre id not found");
        }
        return movies;
    }

    @Override
    public List<Person> findActorsByMovieId(long movieId) throws EntityNotFoundException {
        List<Person> actors = personsRepository.findActorsByMovieId(movieId);
        if (actors.isEmpty()) {
            throw new EntityNotFoundException("Actors by this movie id not found");
        }
        return actors;
    }

    @Override
    public List<Person> findWritersByMovieId(long movieId) throws EntityNotFoundException {
        List<Person> writers = personsRepository.findWritersByMovieId(movieId);
        if (writers.isEmpty()) {
            throw new EntityNotFoundException("Writers by this movie id not found");
        }
        return writers;
    }

    @Override
    public List<Person> findDirectorsByMovieId(long movieId) throws EntityNotFoundException {
        List<Person> directors = personsRepository.findDirectorsByMovieId(movieId);
        if (directors.isEmpty()) {
            throw new EntityNotFoundException("Directors by this movie id not found");
        }
        return directors;
    }
}
