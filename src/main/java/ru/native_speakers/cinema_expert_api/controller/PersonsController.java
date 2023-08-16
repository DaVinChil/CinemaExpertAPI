package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;

import java.util.List;

@RestController
public interface PersonsController {
    @GetMapping("/persons/by-id/{person_id}")
    HttpEntityResponse<PersonDTO> getPersonById(@PathVariable("person_id") int personId);
    @GetMapping("/persons/by-imdb-id/{person_id}")
    HttpEntityResponse<PersonDTO> getPersonByImdbId(@PathVariable("person_id") String personId);
    @GetMapping("/persons/by-name/{person_name}")
    HttpEntityResponse<PersonDTO> getPersonsByName(@PathVariable("person_name") String personName);
    @GetMapping("/actors")
    HttpEntityResponse<PersonDTO> getAllActors(@RequestParam("page") int page, @RequestParam("page_size") int pageSize);
    @GetMapping("/directors")
    HttpEntityResponse<PersonDTO> getAllDirectors(@RequestParam("page") int page, @RequestParam("page_size") int pageSize);
    @GetMapping("/writers")
    HttpEntityResponse<PersonDTO> getAllWriters(@RequestParam("page") int page, @RequestParam("page_size") int pageSize);
}
