package ru.native_speakers.cinema_expert_api.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MoviesRepositoryTest {

    private final MoviesRepository moviesRepository;

    @Autowired
    public MoviesRepositoryTest(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    @Test
    void findByTitle_OptionalIsPresentIfMovieWithThisTitleExists() {
        String movieTitle = "Inception";
        assertTrue(moviesRepository.findByTitle(movieTitle).isPresent());
    }

    @Test
    void findByTitle_OptionalIsEmptyIfMovieWithThisTitleNotExists() {
        String movieTitle = "Wrong movie title";
        assertTrue(moviesRepository.findByTitle(movieTitle).isEmpty());
    }

    @Test
    void findAllByTitleContaining_ResultListIsNotEmptyIfThereAreMoviesContainsThisTitle() {
        String movieTitle = "The Lord of The Rings";
        assertNotEquals(0, moviesRepository.findAllByTitleContaining(movieTitle).size());
    }

    @Test
    void findAllByTitleContaining_ResultListIsEmptyIfThereIsNotAnyMovieTitleContainsThisString() {
        String movieTitle = "There are no movies contains this title";
        assertEquals(0, moviesRepository.findAllByTitleContaining(movieTitle).size());
    }

    @Test
    void findByOrderByChartRatingDesc_DescOrderingTest() {
        List<Movie> movies = moviesRepository.findByOrderByChartRatingDesc(PageRequest.of(0, 20)).getContent();
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
        for (Movie movie : moviesRepository.findByGenreName(genreName, PageRequest.of(0, count))) {
            assertThat(movie.getGenres()).anySatisfy(genre -> genre.getName().equals(genreName));
        }
    }

    @Test
    void findByGenreName_EmptyListIfGenreWithNameNotExists() {
        assertEquals(0, moviesRepository.findByGenreName("Something wrong", PageRequest.of(0, 20)).getContent().size());
    }

    @Test
    void findByGenreId_AllMoviesHavingGenreWithThisId() {
        int genreId = 2;
        int count = 15;
        for (Movie movie : moviesRepository.findByGenreId(genreId, PageRequest.of(0, count))) {
            assertThat(movie.getGenres()).anySatisfy(genre -> Integer.compare(genre.getId(), genreId));
        }
    }
}