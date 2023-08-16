package ru.native_speakers.cinema_expert_api.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Movie;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsServiceImp implements PersonsService {
    private final PersonsRepository personsRepository;

    public PersonsServiceImp(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @Override
    public List<Person> getAllActors(int page, int pageSize) {
        List<Person> persons = personsRepository.findAllActors(PageRequest.of(page, pageSize)).getContent();
        if(persons.isEmpty()){
            throw new EntityNotFoundException("No actors");
        }
        return persons;
    }

    @Override
    public List<Person> getAllWriters(int page, int pageSize) {
        List<Person> persons = personsRepository.findAllWriters(PageRequest.of(page, pageSize)).getContent();
        if(persons.isEmpty()) {
            throw new EntityNotFoundException("No writers");
        }
        return persons;
    }

    @Override
    public List<Person> getAllDirectors(int page, int pageSize) {
        List<Person> persons = personsRepository.findAllDirectors(PageRequest.of(page, pageSize)).getContent();
        if (persons.isEmpty()) {
            throw new EntityNotFoundException("No directors");
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        return personsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No person by given id"));
    }

    @Override
    public List<Person> getPersonsByName(String personName) {
        List<Person> persons = personsRepository.findByFullNameContains(personName);
        if (persons.isEmpty()) {
            throw new EntityNotFoundException("No persons by name");
        }
        return persons;
    }

    @Override
    public Person getPersonByImdbId(String imdbId) {
        return personsRepository.findByImdbId(imdbId).orElseThrow(() -> new EntityNotFoundException("No person by given imdb id."));
    }
}
