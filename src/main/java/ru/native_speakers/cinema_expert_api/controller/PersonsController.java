package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.dto.persons.MovieByPerson;

import java.util.List;

@RestController
public interface PersonsController {
    @GetMapping("/persons/{person_id}/filmography")
    List<MovieByPerson> getMoviesByPersonId(@PathVariable("person_id") int personId);
    @GetMapping("/persons/{person_id}/filmography")
    List<MovieByPerson> getMoviesByPersonImdbId(@PathVariable("person_id") String personId);
    @GetMapping("/persons/{person_id}/filmography")
    List<MovieByPerson> getMoviesByPersonName(@PathVariable("person_id") String personName);
    @GetMapping("/persons/by-id/{person_id}")
    PersonDTO getPersonById(@PathVariable("person_id") int personId);
    @GetMapping("/persons/by-imdb-id/{person_id}")
    PersonDTO getPersonByImdbId(@PathVariable("person_id") String personId);
    @GetMapping("/persons/by-name/{person_name}")
    PersonDTO getPersonById(@PathVariable("person_name") String personName);
    @GetMapping("/actors")
    List<PersonDTO> getAllActors();
    @GetMapping("/directors")
    List<PersonDTO> getAllDirectors();
    @GetMapping("/writers")
    List<PersonDTO> getAllWriters();
    @GetMapping("/persons")
    List<PersonDTO> getAllPersons();
}
