package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImplementation implements MoviesService {

    private final MoviesRepository moviesRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Movie> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public List<Movie> findAllOrderByRating(int count) {
        return moviesRepository.findAllByOrderByChartRatingDescLimit(count);
    }

    @Override
    public List<Movie> findAllOrderByRating() {
        return moviesRepository.findAllByOrderByChartRatingDesc();
    }

    @Override
    public List<Movie> findTopByGenreName(int count, String genreName) {
        return null;
    }

    @Override
    public List<Movie> findTopByGenreId(int count, int genreId) {
        return null;
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

    @Override
    public MovieDTO convertMovieToMovieDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }

    @Override
    public List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies) {
        System.out.println("123");
        List<MovieDTO> movieDTOS = new ArrayList<>();
        movies.forEach(movie -> {
            System.out.println("before add");
            movieDTOS.add(convertMovieToMovieDTO(movie));
            System.out.println("after add");
        });
        return movieDTOS;
    }

    @Override
    public Movie convertMovieDTOToMovie(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    @Override
    public List<Movie> convertMovieDTOToMovie(List<MovieDTO> movieDTOS) {
        List<Movie> movies = new ArrayList<>();
        movieDTOS.forEach(movieDTO -> movies.add(convertMovieDTOToMovie(movieDTO)));
        return movies;
    }
}
