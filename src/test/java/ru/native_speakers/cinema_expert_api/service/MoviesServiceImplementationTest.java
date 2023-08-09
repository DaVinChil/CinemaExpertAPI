package ru.native_speakers.cinema_expert_api.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;

@ExtendWith(MockitoExtension.class)
class MoviesServiceImplementationTest {

    @InjectMocks
    private MoviesServiceImplementation moviesService;

    @Mock
    private MoviesRepository moviesRepository;

    @Test
    void findMovieByMovieId_CorrectResultReturnsIfMovieWithThisIdExists() {
        int movieId = 12;
    }
}
