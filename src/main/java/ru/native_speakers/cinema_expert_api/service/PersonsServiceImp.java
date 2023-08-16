package ru.native_speakers.cinema_expert_api.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonsServiceImp implements PersonsService{
    private final PersonsRepository personsRepository;

    public PersonsServiceImp(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @Override
    public List<Movie> getPersonMoviesAsActorByPersonId(int id) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsWritePersonId(int id) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsDirectorPersonId(int id) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsActorByPersonImdbId(String id) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsWriteByPersonImdbId(String id) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsDirectorByPersonImdbId(String id) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsActorByPersonName(String name) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsWriteByPersonName(String name) {
        return null;
    }

    @Override
    public List<Movie> getPersonMoviesAsDirectorByPersonName(String name) {
        return null;
    }

    @Override
    public List<Person> getAllActors(int page, int pageSize) {
        return personsRepository.findAllActors(PageRequest.of(page, pageSize)).getContent();
    }

    @Override
    public List<Person> getAllWriters(int page, int pageSize) {
        return personsRepository.findAllWriters(PageRequest.of(page, pageSize)).getContent();
    }

    @Override
    public List<Person> getAllDirectors(int page, int pageSize) {
        return personsRepository.findAllDirectors(PageRequest.of(page, pageSize)).getContent();
    }
}
