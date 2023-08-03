package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Genre;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
