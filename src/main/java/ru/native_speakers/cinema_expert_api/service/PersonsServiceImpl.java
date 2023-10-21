package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.repository.PersonsRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsServiceImpl implements PersonsService {
    private final PersonsRepository personsRepository;

    @Override
    public List<Person> findAllActors(int page, int pageSize) throws EntityNotFoundException {
        List<Person> persons = personsRepository.findAllActors(PageRequest.of(page, pageSize)).getContent();
        if(persons.isEmpty()){
            throw new EntityNotFoundException("No actors");
        }
        return persons;
    }

    @Override
    public List<Person> findAllWriters(int page, int pageSize) throws EntityNotFoundException {
        List<Person> persons = personsRepository.findAllWriters(PageRequest.of(page, pageSize)).getContent();
        if(persons.isEmpty()) {
            throw new EntityNotFoundException("No writers");
        }
        return persons;
    }

    @Override
    public List<Person> findAllDirectors(int page, int pageSize) throws EntityNotFoundException {
        List<Person> persons = personsRepository.findAllDirectors(PageRequest.of(page, pageSize)).getContent();
        if (persons.isEmpty()) {
            throw new EntityNotFoundException("No directors");
        }
        return persons;
    }

    @Override
    public Person findPersonByPersonId(long id) throws EntityNotFoundException {
        return personsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No person by given id"));
    }

    @Override
    public List<Person> findPersonsByName(String personName) throws EntityNotFoundException {
        List<Person> persons = personsRepository.findByFullNameContains(personName);
        if (persons.isEmpty()) {
            throw new EntityNotFoundException("No persons by name");
        }
        return persons;
    }

    public Person findPersonByImdbId(String imdbId) throws EntityNotFoundException {
        return personsRepository.findByImdbId(imdbId).orElseThrow(() -> new EntityNotFoundException("No person by given imdb id."));
    }
}
