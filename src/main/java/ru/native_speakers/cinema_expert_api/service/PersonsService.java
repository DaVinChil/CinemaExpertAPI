package ru.native_speakers.cinema_expert_api.service;

import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonsService {
    List<Person> getAllActors(int page, int pageSize);
    List<Person> getAllWriters(int page, int pageSize);
    List<Person> getAllDirectors(int page, int pageSize);
    Person getPersonById(int id);
    List<Person> getPersonsByName(String personName);
    Person getPersonByImdbId(String imdbId);
}
