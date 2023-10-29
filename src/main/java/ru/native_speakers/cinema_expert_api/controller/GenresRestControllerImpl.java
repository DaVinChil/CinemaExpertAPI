package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.GenreDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.service.GenresService;
import java.util.List;

import static ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO.convertGenreToGenreDTO;

@RestController
public class GenresRestControllerImpl implements GenresController {
    private final GenresService genresService;

    public GenresRestControllerImpl(@Qualifier("genresServiceImpl") GenresService genresService) {
        this.genresService = genresService;
    }

    @Override
    public HttpEntityResponse<List<GenreDTO>> findGenres(int pageSize, int page) {
        return new HttpEntityResponse<>(convertGenreToGenreDTO(genresService.findGenres(pageSize, page)));
    }

    @Override
    public HttpEntityResponse<GenreDTO> findGenreById(long genreId) {
        return new HttpEntityResponse<>(convertGenreToGenreDTO(genresService.findGenreByGenreId(genreId)));
    }
}
