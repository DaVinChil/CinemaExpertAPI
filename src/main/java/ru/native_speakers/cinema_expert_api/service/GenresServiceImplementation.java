package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.model.Genre;
import ru.native_speakers.cinema_expert_api.repository.GenresRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenresServiceImplementation implements GenresService {

    private final GenresRepository genresRepository;

    @Override
    public List<Genre> findGenres(int count) {
        return genresRepository.findGenres(count);
    }

    @Override
    public Optional<Genre> findGenreById(int genreId) {
        return genresRepository.findById(genreId);
    }
}
