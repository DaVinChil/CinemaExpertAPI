package ru.native_speakers.cinema_expert_api.service;

import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

@Service
public interface SqlIdPersonsService {
    List<Person> getAllMovieActors(int id);
    List<Movie> getPersonFilmography(int id);
    List<Person> getAllActors();
    List<Person> getAllWriters();
    List<Person> getAllDirectors();
}
