package ru.native_speakers.cinema_expert_api.service;

import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

@Service
public interface PersonsService {
    List<Movie> getPersonMoviesAsActorByPersonId(int id);
    List<Movie> getPersonMoviesAsWritePersonId(int id);
    List<Movie> getPersonMoviesAsDirectorPersonId(int id);

    List<Movie> getPersonMoviesAsActorByPersonImdbId(String id);
    List<Movie> getPersonMoviesAsWriteByPersonImdbId(String id);
    List<Movie> getPersonMoviesAsDirectorByPersonImdbId(String id);

    List<Movie> getPersonMoviesAsActorByPersonName(String name);
    List<Movie> getPersonMoviesAsWriteByPersonName(String name);
    List<Movie> getPersonMoviesAsDirectorByPersonName(String name);

    List<Person> getAllActors(int page, int pageSize);
    List<Person> getAllWriters(int page, int pageSize);
    List<Person> getAllDirectors(int page, int pageSize);
}
