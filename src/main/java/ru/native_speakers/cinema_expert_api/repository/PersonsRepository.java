package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Integer> {

    @Query(
            value = "select persons.* from movies join movies_directors on movies.movie_id = movies_directors.movie_id join persons on movies_directors.person_id = persons.person_id where movies.movie_id = :movieId",
            nativeQuery = true
    )
    List<Person> findDirectorsByMovieId(@Param("movieId") int movieId);
}
