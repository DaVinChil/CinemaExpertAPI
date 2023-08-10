package ru.native_speakers.cinema_expert_api.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MoviesServiceImplementationTest {

    @Mock
    private MoviesRepository moviesRepository;

    @Mock
    private Movie movie;

    @InjectMocks
    private MoviesServiceImplementation moviesService;

    @Test
    void findMovieByMovieId_ReturnsMovieClassIfRepositoryReturnsPresentOptional() {
        when(moviesRepository.findById(anyInt())).thenReturn(Optional.of(movie));

        int movieId = 1;
        assertThat(moviesService.findMovieByMovieId(movieId)).isInstanceOf(Movie.class);
    }

    @Test
    void findMovieByMovieId_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyOptional() {
        when(moviesRepository.findById(anyInt())).thenReturn(Optional.empty());

        int movieId = 1001;
        assertThrows(EntityNotFoundException.class, () -> moviesService.findMovieByMovieId(movieId));
    }

    @Test
    void findMovieByMovieTitle_ReturnsMovieClassIfRepositoryReturnsPresentOptional() {
        when(moviesRepository.findByTitle(anyString())).thenReturn(Optional.of(movie));

        String movieTitle = "Inception";
        assertThat(moviesService.findMovieByMovieTitle(movieTitle)).isInstanceOf(Movie.class);
    }

    @Test
    void findMovieByMovieTitle_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyOptional() {
        when(moviesRepository.findByTitle(anyString())).thenReturn(Optional.empty());

        String movieTitle = "Wrong title";
        assertThrows(EntityNotFoundException.class, () -> moviesService.findMovieByMovieTitle(movieTitle));
    }

    @Test
    void findMoviesByMoviesTitleContaining_ReturnsListOfMovieClassIfRepositoryReturnsNotEmptyListOfMovieClass() {
        when(moviesRepository.findAllByTitleContaining(anyString())).thenReturn(List.of(movie));

        String movieTitle = "Inc";
        List<Movie> result = moviesService.findMoviesByMoviesTitleContaining(movieTitle);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void findMoviesByMoviesTitleContaining_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyListOfMovieClass() {
        when(moviesRepository.findAllByTitleContaining(anyString())).thenReturn(Collections.emptyList());

        String movieTitle = "Wrong title";
        assertThrows(EntityNotFoundException.class, () -> moviesService.findMoviesByMoviesTitleContaining(movieTitle));
    }

    @Test
    void findTopByGenreName_ReturnsNotEmptyResultRepositoryReturnsNotEmptyListOfMovieClass() {
        when(moviesRepository.findByGenreName(anyString(), anyInt())).thenReturn(List.of(movie));

        String genreName = "Drama";
        int count = 15;
        List<Movie> result = moviesService.findTopByGenreName(genreName, count);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void findTopByGenreName_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyListOfMovieClass() {
        when(moviesRepository.findByGenreName(anyString(), anyInt())).thenReturn(Collections.emptyList());

        String genreName = "Wrong genre";
        int count = 15;
        assertThrows(EntityNotFoundException.class, () -> moviesService.findTopByGenreName(genreName, count));
    }

    @Test
    void findTopByGenreId_ReturnsListOfMovieClassIfRepositoryReturnsNotEmptyListOfMovieClass() {
        when(moviesRepository.findByGenreId(anyInt(), anyInt())).thenReturn(List.of(movie));

        int genreId = 2;
        int count = 15;
        List<Movie> result = moviesService.findTopByGenreId(genreId, count);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void findTopByGenreId_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyListOfMovieClass() {
        when(moviesRepository.findByGenreId(anyInt(), anyInt())).thenReturn(Collections.emptyList());

        int genreId = 2;
        int count = 15;
        assertThrows(EntityNotFoundException.class, () -> moviesService.findTopByGenreId(genreId, count));
    }
}
