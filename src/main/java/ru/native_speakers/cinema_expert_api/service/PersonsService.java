package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

public interface PersonsService {
    List<Person> findAllActors(int page, int pageSize) throws EntityNotFoundException;
    List<Person> findAllWriters(int page, int pageSize) throws EntityNotFoundException;
    List<Person> findAllDirectors(int page, int pageSize) throws EntityNotFoundException;
    Person findPersonByPersonId(long personId) throws EntityNotFoundException;
    List<Person> findPersonsByName(String personName) throws EntityNotFoundException;
    Person findPersonByImdbId(String imdbId) throws EntityNotFoundException;
}
