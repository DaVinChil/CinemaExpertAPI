package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Genre;
import ru.native_speakers.cinema_expert_api.repository.GenresRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenresServiceImp implements GenresService {

    private final GenresRepository genresRepository;

    @Override
    public List<Genre> findGenres(int pageSize, int page) throws EntityNotFoundException {
        List<Genre> genres = genresRepository.findAll(PageRequest.of(page, pageSize)).getContent();
        if (genres.isEmpty()) {
            throw new EntityNotFoundException("Genres not found");
        }
        return genres;
    }

    @Override
    public Genre findGenreById(int genreId) {
        Optional<Genre> optionalGenre = genresRepository.findById(genreId);
        if (optionalGenre.isEmpty()) {
            throw new EntityNotFoundException("Genre with this id not found");
        }
        return optionalGenre.get();
    }

    @Override
    public long getGenresCount() {
        return genresRepository.count();
    }
}
