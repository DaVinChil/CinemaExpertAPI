package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.persons.MovieByPerson;
import ru.native_speakers.cinema_expert_api.dto.persons.PersonDto;
import ru.native_speakers.cinema_expert_api.service.PersonsService;

import java.util.List;

@RestController
public class PersonsControllerImp implements PersonsController{
    private final PersonsService personsService;

    public PersonsControllerImp(PersonsService personsService) {
        this.personsService = personsService;
    }

    @Override
    public List<PersonDto> getActorsByMovieId(int movieId) {
        return null;
    }

    @Override
    public List<MovieByPerson> getMoviesByPersonId(int personId) {
        return null;
    }

    @Override
    public List<PersonDto> getAllActors() {
        return null;
    }

    @Override
    public List<PersonDto> getAllDirectors() {
        return null;
    }

    @Override
    public List<PersonDto> getAllWriters() {
        return null;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return null;
    }
}
