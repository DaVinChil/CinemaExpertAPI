package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

public interface PersonsService {
    List<Person> getAllActors(int page, int pageSize);
    List<Person> getAllWriters(int page, int pageSize);
    List<Person> getAllDirectors(int page, int pageSize);
    Person getPersonByPersonId(long personId);
    List<Person> getPersonsByName(String personName);
    Person getPersonByImdbId(String imdbId);
}
