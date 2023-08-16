package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {

    Optional<Movie> findByTitle(String title);
    Page<Movie> findAllByTitleContaining(String movieTitle, Pageable pageable);
    Page<Movie> findByOrderByChartRatingDesc(Pageable pageable);

    @Query(
            value = "select movies.* from movies join movies_genres on movies.movie_id = movies_genres.movie_id join genres on genres.genre_id = movies_genres.genre_id where lower(genres.name) = lower(:genreName)",
            countQuery = "select count(*) from movies join movies_genres on movies.movie_id = movies_genres.movie_id join genres on genres.genre_id = movies_genres.genre_id where lower(genres.name) = lower(:genreName)",
            nativeQuery = true
    )
    Page<Movie> findAllByGenreName(@Param("genreName") String genreName, Pageable pageable);

    @Query(
            value = "select movies.* from movies join movies_genres on movies.movie_id = movies_genres.movie_id join genres on genres.genre_id = movies_genres.genre_id where genres.genre_id = :genreId",
            countQuery = "select count(*) from movies join movies_genres on movies.movie_id = movies_genres.movie_id join genres on genres.genre_id = movies_genres.genre_id where genres.genre_id = :genreId",
            nativeQuery = true
    )
    Page<Movie> findAllByGenreId(@Param("genreId") int genreId, Pageable pageable);
}
