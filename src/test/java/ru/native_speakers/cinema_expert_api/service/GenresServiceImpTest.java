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
import ru.native_speakers.cinema_expert_api.model.Genre;
import ru.native_speakers.cinema_expert_api.repository.GenresRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class GenresServiceImpTest {

    @Mock
    private GenresRepository genresRepository;

    @Mock
    private Genre genre;

    @InjectMocks
    private GenresServiceImp genresService;

    @Test
    void findGenreById_ReturnsGenreClassIfRepositoryReturnsPresentOptional() {
        when(genresRepository.findById(any())).thenReturn(Optional.of(genre));

        int movieId = 2;
        assertThat(genresService.findGenreById(movieId)).isInstanceOf(Genre.class);
    }

    @Test
    void findGenreById_ThrowsEntityNotFoundExceptionIfRepositoryReturnsEmptyOptional() {
        when(genresRepository.findById(any())).thenReturn(Optional.empty());

        int movieId = 1001;
        assertThrows(EntityNotFoundException.class, () -> genresService.findGenreById(movieId));
    }
}
