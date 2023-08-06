package ru.native_speakers.cinema_expert_api.repository;

import lombok.RequiredArgsConstructor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@RequiredArgsConstructor
public class MoviesRepositoryTest {

    @Autowired
    private final MoviesRepository moviesRepository;

    @Test
    void findByOrderByChartRatingDescExactSizeReturnTest() {
        assertEquals(0, moviesRepository.findByOrderByChartRatingDesc(0).size());
        assertEquals(3, moviesRepository.findByOrderByChartRatingDesc(3).size());
        assertEquals(5, moviesRepository.findByOrderByChartRatingDesc(5).size());
        assertEquals(100, moviesRepository.findByOrderByChartRatingDesc(100).size());
    }

}