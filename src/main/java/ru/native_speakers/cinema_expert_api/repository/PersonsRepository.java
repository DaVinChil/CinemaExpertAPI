package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {

    @Query(
            value = "select persons.* from movies join movies_directors on movies.movie_id = movies_directors.movie_id join persons on movies_directors.person_id = persons.person_id where movies.movie_id = :movieId",
            nativeQuery = true
    )
    List<Person> findDirectorsByMovieId(@Param("movieId") long movieId);

    @Query(
            value = """
                    select persons.* from movies_actors
                    join persons on persons.person_id = movies_actors.person_id
                    """,
            countQuery = """
                    select count(*) from movies_actors
                    join persons on persons.person_id = movies_actors.person_id
                    """,
            nativeQuery = true
    )
    Page<Person> findAllActors(Pageable pageable);

    @Query(
            value = """
                    select persons.* from movies_writers
                    join persons on persons.person_id = movies_writers.person_id
                    """,
            countQuery = """
                    select count(*) from movies_writers
                    join persons on persons.person_id = movies_writers.person_id
                    """,
            nativeQuery = true
    )
    Page<Person> findAllWriters(Pageable pageable);

    @Query(
            value = """
                    select persons.* from movies_directors
                    join persons on persons.person_id = movies_directors.person_id
                    """,
            countQuery = """
                    select count(*) from movies_directors
                    join persons on persons.person_id = movies_directors.person_id
                    """,
            nativeQuery = true
    )
    Page<Person> findAllDirectors(Pageable pageable);

    Optional<Person> findByImdbId(String imdbId);
    Optional<Person> findById(long id);
    List<Person> findByFullNameContains(String personName);
}
