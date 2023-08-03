package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.MoviesRepository;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImplementation implements MoviesService {

    private final MoviesRepository moviesRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Movie> findAll() {
        return moviesRepository.findAll();
    }

    @Override
    public List<Movie> findAllOrderByRating(int count) {
        return moviesRepository.findByOrderByChartRatingDesc(count);
    }

    @Override
    public List<Movie> findTopByGenreName(int count, String genreName) {
        return moviesRepository.findByGenreName(genreName, count);
    }

    @Override
    public List<Movie> findTopByGenreId(int count, int genreId) {
        return moviesRepository.findByGenreId(genreId, count);
    }

    @Override
    public List<Person> findDirectorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<Person> findWritersByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<Person> findActorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public MovieDTO convertMovieToMovieDTO(Movie movie) {
        MovieDTO movieDTO = modelMapper.map(movie, MovieDTO.class);
        movie.getDirectors().forEach(director -> movieDTO.addDirectorId(director.getId()));
        movie.getWriters().forEach(writer -> movieDTO.addWriterId(writer.getId()));
        movie.getActors().forEach(actor -> movieDTO.addActorId(actor.getId()));
        movie.getCharacters().forEach(character -> movieDTO.addCharacterId(character.getId()));
        return movieDTO;
    }

    @Override
    public List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies) {
        List<MovieDTO> movieDTOS = new ArrayList<>();
        movies.forEach(movie -> movieDTOS.add(convertMovieToMovieDTO(movie)));
        return movieDTOS;
    }
}
