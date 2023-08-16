package ru.native_speakers.cinema_expert_api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.GenreDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.model.Genre;
import ru.native_speakers.cinema_expert_api.service.GenresService;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GenresRestControllerImplementation implements GenresController {

    private final GenresService genresService;
    private final ModelMapper modelMapper;

    public GenresRestControllerImplementation(@Qualifier(value = "genresServiceImp") GenresService genresService,
                                              ModelMapper modelMapper) {
        this.genresService = genresService;
        this.modelMapper = modelMapper;
    }

    @Override
    public HttpEntityResponse<List<GenreDTO>> getGenres(int pageSize, int page) {
        return new HttpEntityResponse<>(convertGenreToGenreDTO(genresService.findGenres(pageSize, page)));
    }

    @Override
    public HttpEntityResponse<GenreDTO> getGenreById(int genreId) {
        return new HttpEntityResponse<>(convertGenreToGenreDTO(genresService.findGenreById(genreId)));
    }

    @Override
    public GenreDTO convertGenreToGenreDTO(Genre genre) {
        return modelMapper.map(genre, GenreDTO.class);
    }

    @Override
    public List<GenreDTO> convertGenreToGenreDTO(List<Genre> genres) {
        List<GenreDTO> genreDTOS = new ArrayList<>();
        genres.forEach(genre -> genreDTOS.add(convertGenreToGenreDTO(genre)));
        return genreDTOS;
    }
}
