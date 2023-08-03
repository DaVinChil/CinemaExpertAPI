package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select * from movies order by chart_rating desc limit :count", nativeQuery = true)
    List<Movie> findByOrderByChartRatingDesc(@Param("count") int count);

    @Query(value = "select movies.* from movies join movies_genres on movies.movie_id = movies_genres.movie_id" +
            "join genres on genres.genre_id = movies_genres.genre_id where lower(genres.name) = lower(:genreName) limit :count",
            nativeQuery = true)
    List<Movie> findByGenreName(@Param("genreName") String genreName, @Param("count") int count);

    @Query(value = "select movies.* from movies join movies_genres on movies.movie_id = movies_genres.movie_id" +
            "join genres on genres.genre_id = movies_genres.genre_id where genres.genre_id = :genreId limit :count", nativeQuery = true)
    List<Movie> findByGenreId(@Param("genreId") int genreId, @Param("count") int count);

    @Query(value = "select persons.* from movies join movies_directors on movies.movie_id = movies_directors.movie_id" +
            "join persons on movies_directors.person_id = persons.person_id where movies.movie_id = :movieId", nativeQuery = true)
    List<Person> findDirectorsByMovieId(@Param("movieId") int movieId);
}
