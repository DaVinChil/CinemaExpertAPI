package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Genre;
import java.util.List;

public interface GenresService {
    List<Genre> findGenres(int count);
    Genre findGenreById(int genreId) throws EntityNotFoundException;
}
