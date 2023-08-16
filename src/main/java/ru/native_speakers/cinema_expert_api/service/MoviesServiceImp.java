package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImp implements MoviesService {

    private final MoviesRepository moviesRepository;

    @Override
    public Movie findMovieByMovieId(int movieId) throws EntityNotFoundException {
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
    public List<Movie> findAllOrderByRating(int pageSize, int page) {
        return moviesRepository.findByOrderByChartRatingDesc(PageRequest.of(page, pageSize)).getContent();
    }

    @Override
    public List<Movie> findTopByGenreName(String genreName, int pageSize, int page) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findAllByGenreName(genreName,
                PageRequest.of(page, pageSize, Sort.by("chartRating").descending())).getContent();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies by this genre not found");
        }
        return movies;
    }

    @Override
    public List<Movie> findTopByGenreId(int genreId, int pageSize, int page) throws EntityNotFoundException {
        List<Movie> movies = moviesRepository.findAllByGenreId(genreId,
                PageRequest.of(page, pageSize, Sort.by("chartRating"))).getContent();
        if (movies.isEmpty()) {
            throw new EntityNotFoundException("Movies by this genre id not found");
        }
        return movies;
    }

    @Override
    public long getMoviesCount() {
        return moviesRepository.count();
    }
}
