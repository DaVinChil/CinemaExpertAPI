package ru.native_speakers.cinema_expert_api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.GenreDTO;
import ru.native_speakers.cinema_expert_api.model.Genre;
import ru.native_speakers.cinema_expert_api.service.GenresService;
import ru.native_speakers.cinema_expert_api.util.genre.GenreNotFoundException;
import ru.native_speakers.cinema_expert_api.util.genre.GenreNotFoundResponse;
import ru.native_speakers.cinema_expert_api.util.genre.InvalidQueryParametersException;
import ru.native_speakers.cinema_expert_api.util.genre.InvalidQueryParametersResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GenresRestControllerImplementation implements GenresController {

    private final GenresService genresService;
    private final ModelMapper modelMapper;

    public GenresRestControllerImplementation(@Qualifier(value = "genresServiceImplementation") GenresService genresService,
                                              ModelMapper modelMapper) {
        this.genresService = genresService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GenreDTO> getGenres(int count) {
        if (count < 0) {
            throw new InvalidQueryParametersException("Parameter 'count' cannot be negative");
        }
        return convertGenreToGenreDTO(genresService.findGenres(count));
    }

    @Override
    public GenreDTO getGenreById(int genreId) {
        Optional<Genre> genreOptional = genresService.findGenreById(genreId);
        if (genreOptional.isPresent()) {
            return convertGenreToGenreDTO(genreOptional.get());
        } else {
            throw new GenreNotFoundException("Genre with this id not found");
        }
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

    @Override
    public GenreNotFoundResponse handleGenreNotFoundException(GenreNotFoundException e) {
        return new GenreNotFoundResponse(e.getMessage());
    }

    @Override
    public InvalidQueryParametersResponse handleInvalidQueryParametersException(InvalidQueryParametersException e) {
        return new InvalidQueryParametersResponse(e.getMessage());
    }
}
