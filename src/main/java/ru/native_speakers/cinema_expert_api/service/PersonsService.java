package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

public interface PersonsService {
    List<Person> getAllActors(int page, int pageSize) throws EntityNotFoundException;
    List<Person> getAllWriters(int page, int pageSize) throws EntityNotFoundException;
    List<Person> getAllDirectors(int page, int pageSize) throws EntityNotFoundException;
    Person getPersonByPersonId(long personId) throws EntityNotFoundException;
    List<Person> getPersonsByName(String personName) throws EntityNotFoundException;
    Person getPersonByImdbId(String imdbId) throws EntityNotFoundException;
}
