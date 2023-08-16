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
        int page = 0;
        int pageSize = 10;
        assertNotEquals(0, moviesRepository.findAllByTitleContaining(movieTitle, PageRequest.of(page, pageSize)).getContent().size());
    }

    @Test
    void findAllByTitleContaining_ResultListIsEmptyIfThereIsNotAnyMovieTitleContainsThisString() {
        String movieTitle = "There are no movies contains this title";
        int page = 0;
        int pageSize = 10;
        assertEquals(0, moviesRepository.findAllByTitleContaining(movieTitle, PageRequest.of(page, pageSize)).getContent().size());
    }

    @Test
    void findByOrderByChartRatingDesc_DescOrderingTest() {
        int page = 0;
        int pageSize = 10;
        List<Movie> movies = moviesRepository.findByOrderByChartRatingDesc(PageRequest.of(page, pageSize)).getContent();
        for (int i = 1; i < movies.size(); ++i) {
            Movie previous = movies.get(i - 1);
            Movie current = movies.get(i);
            assertThat(previous.getChartRating()).isGreaterThanOrEqualTo(current.getChartRating());
        }
    }

    @Test
    void findByGenreName_AllMoviesHaveThisGenreTest() {
        String genreName = "Sci-fi";
        int page = 0;
        int pageSize = 10;
        for (Movie movie : moviesRepository.findAllByGenreName(genreName, PageRequest.of(page, pageSize)).getContent()) {
            assertThat(movie.getGenres()).anySatisfy(genre -> genre.getName().equals(genreName));
        }
    }

    @Test
    void findByGenreName_EmptyListIfGenreWithNameNotExists() {
        String genreName = "Something wrong";
        int page = 0;
        int pageSize = 10;
        assertEquals(0, moviesRepository.findAllByGenreName(genreName, PageRequest.of(page, pageSize)).getContent().size());
    }

    @Test
    void findByGenreId_AllMoviesHavingGenreWithThisId() {
        int genreId = 2;
        int page = 0;
        int pageSize = 10;
        for (Movie movie : moviesRepository.findAllByGenreId(genreId, PageRequest.of(page, pageSize)).getContent()) {
            assertThat(movie.getGenres()).anySatisfy(genre -> Integer.compare(genre.getId(), genreId));
        }
    }
}