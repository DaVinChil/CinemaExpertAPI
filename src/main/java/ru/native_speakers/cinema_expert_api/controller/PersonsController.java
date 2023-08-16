package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.persons.MovieByPerson;
import ru.native_speakers.cinema_expert_api.dto.persons.PersonDto;

import java.util.List;

@RestController
public interface PersonsController {
    @GetMapping("/actors/by-movie-id")
    List<PersonDto> getActorsByMovieId(@RequestParam("movie_id") int movieId);
    @GetMapping("/persons/{person_id}/filmography")
    List<MovieByPerson> getMoviesByPersonId(@PathVariable("person_id") int personId);
    @GetMapping("/actors")
    List<PersonDto> getAllActors();
    @GetMapping("/directors")
    List<PersonDto> getAllDirectors();
    @GetMapping("/writers")
    List<PersonDto> getAllWriters();
    @GetMapping("/persons")
    List<PersonDto> getAllPersons();
}
