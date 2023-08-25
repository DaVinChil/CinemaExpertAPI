package ru.native_speakers.cinema_expert_api.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MoviesServiceImplTest {

    @Mock
    private MoviesRepository moviesRepository;

    @Mock
    private Movie movie;

    @InjectMocks
    private MoviesServiceImpl moviesService;

    @Test
    void findMovieByMovieId_ReturnsMovieClassIfRepositoryReturnsPresentOptional() {
        when(moviesRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        long movieId = 1;
        assertThat(moviesService.findMovieByMovieId(movieId)).isInstanceOf(Movie.class);
    }

    @Test
    void findMovieByMovieId_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyOptional() {
        when(moviesRepository.findById(anyLong())).thenReturn(Optional.empty());

        long movieId = 1001;
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
        when(moviesRepository.findAllByTitleContaining(anyString(), any(Pageable.class))).thenReturn(new PageImpl<>(List.of(movie)));

        String movieTitle = "Inc";
        int page = 0;
        int pageSize = 10;
        List<Movie> result = moviesService.findMoviesByMoviesTitleContaining(movieTitle, pageSize, page);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void findMoviesByMoviesTitleContaining_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyListOfMovieClass() {
        when(moviesRepository.findAllByTitleContaining(anyString(), any(Pageable.class))).thenReturn(Page.empty());

        String movieTitle = "Wrong title";
        int pageSize = 10;
        int page = 0;
        assertThrows(EntityNotFoundException.class, () -> moviesService.findMoviesByMoviesTitleContaining(movieTitle, pageSize, page));
    }

    @Test
    void findTopByGenreName_ReturnsNotEmptyResultRepositoryReturnsNotEmptyListOfMovieClass() {
        when(moviesRepository.findAllByGenreName(anyString(), any(Pageable.class))).thenReturn(new PageImpl<>(List.of(movie)));

        String genreName = "Drama";
        int pageSize = 10;
        int page = 0;
        List<Movie> result = moviesService.findTopByGenreName(genreName, pageSize, page);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void findTopByGenreName_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyListOfMovieClass() {
        when(moviesRepository.findAllByGenreName(anyString(), any(Pageable.class))).thenReturn(Page.empty());

        String genreName = "Wrong genre";
        int page = 0;
        int pageSize = 10;
        assertThrows(EntityNotFoundException.class, () -> moviesService.findTopByGenreName(genreName, pageSize, page));
    }

    @Test
    void findTopByGenreId_ReturnsListOfMovieClassIfRepositoryReturnsNotEmptyListOfMovieClass() {
        when(moviesRepository.findAllByGenreId(anyLong(), any(Pageable.class))).thenReturn(new PageImpl<>(List.of(movie)));

        long genreId = 2;
        int page = 0;
        int pageSize = 10;
        List<Movie> result = moviesService.findTopByGenreId(genreId, pageSize, page);
        assertThat(result).isNotNull();
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void findTopByGenreId_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyListOfMovieClass() {
        when(moviesRepository.findAllByGenreId(anyLong(), any(Pageable.class))).thenReturn(Page.empty());

        long genreId = 2;
        int page = 0;
        int pageSize = 10;
        assertThrows(EntityNotFoundException.class, () -> moviesService.findTopByGenreId(genreId, pageSize, page));
    }
}
