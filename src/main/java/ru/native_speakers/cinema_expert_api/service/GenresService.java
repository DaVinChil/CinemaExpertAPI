package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Genre;
import java.util.List;
import java.util.Optional;

public interface GenresService {
    List<Genre> findGenres(int count);
    Optional<Genre> findGenreById(int genreId);
}
