package ru.native_speakers.cinema_expert_api.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MoviesRepositoryTest {

    @Autowired
    private MoviesRepository moviesRepository;

    @Test
    void findByOrderByChartRatingDesc_ExactSizeReturnTest() {
        assertEquals(0, moviesRepository.findByOrderByChartRatingDesc(0).size());
        assertEquals(3, moviesRepository.findByOrderByChartRatingDesc(3).size());
        assertEquals(5, moviesRepository.findByOrderByChartRatingDesc(5).size());
        assertEquals(100, moviesRepository.findByOrderByChartRatingDesc(100).size());
    }

    @Test
    void findByOrderByChartRatingDesc_DescOrderingTest() {
        List<Movie> movies = moviesRepository.findByOrderByChartRatingDesc(40);
        for (int i = 1; i < movies.size(); ++i) {
            Movie previous = movies.get(i - 1);
            Movie current = movies.get(i);
            assertThat(previous.getChartRating()).isGreaterThanOrEqualTo(current.getChartRating());
        }
    }

    @Test
    void findByGenreName_AllMoviesHaveThisGenreTest() {
        String genreName = "Sci-fi";
        int count = 15;
        for (Movie movie : moviesRepository.findByGenreName(genreName, count)) {
            assertThat(movie.getGenres()).anySatisfy(genre -> genre.getName().equals(genreName));
        }
    }

    @Test
    void findByGenreName_EmptyListIfGenreWithNameNotExists() {
        assertEquals(0, moviesRepository.findByGenreName("Something wrong", 100).size());
    }

    @Test
    void findByGenreId_AllMoviesHavingGenreWithThisId() {
        int genreId = 2;
        int count = 15;
        for (Movie movie : moviesRepository.findByGenreId(genreId, count)) {
            assertThat(movie.getGenres()).anySatisfy(genre -> Integer.compare(genre.getId(), genreId));
        }
    }

}