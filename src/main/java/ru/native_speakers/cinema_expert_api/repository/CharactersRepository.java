package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.Character;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharactersRepository extends JpaRepository<Character, Long> {
    List<Character> findByNameContains(String name);
}
