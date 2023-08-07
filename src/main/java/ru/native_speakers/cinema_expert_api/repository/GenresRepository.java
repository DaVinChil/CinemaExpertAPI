package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Genre;
import java.util.List;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {

    @Query(value = "select * from genres limit :count", nativeQuery = true)
    List<Genre> findGenres(@Param("count") int count);
}
