package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Movie;
import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByOrderByChartRatingDesc();

    @Query(value = "select * from movies order by chart_rating limit :count", nativeQuery = true)
    List<Movie> findAllByOrderByChartRatingDescLimit(@Param("count") int count);

    @Query(value = "select movies.* from movies join movies_genres on movies.movie_id = movies_genres.movie_id" +
            "join genres on genres.genre_id = movies_genres.genre_id where genres.name = :genreName", nativeQuery = true)
    List<Movie> findAllByGenre(@Param("genreName") String genreName);
}
