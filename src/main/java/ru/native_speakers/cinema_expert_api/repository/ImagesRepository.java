package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Image;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Image, Integer> {

    @Query(value = "select * from images limit :count", nativeQuery = true)
    List<Image> findAll(@Param("count") int count);
}
