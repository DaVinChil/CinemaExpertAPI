package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;

import java.util.List;

@RestController
public interface PersonsController {
    @GetMapping("/persons/{person_id}")
    HttpEntityResponse<PersonDTO> getPersonById(@PathVariable("person_id") @Min(value = 1, message = "Person id cannot be less than 1") int personId);
    @GetMapping("/persons/by-imdb-id/{person_id}")
    HttpEntityResponse<PersonDTO> getPersonByImdbId(@PathVariable("person_id") String personId);
    @GetMapping("/persons/by-name/{person_name}")
    HttpEntityResponse<List<PersonDTO>> getPersonsByName(@PathVariable("person_name") String personName);
    @GetMapping("/actors")
    HttpEntityResponse<List<PersonDTO>> getAllActors(@RequestParam(name = "page_size")
                                                     @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                                     @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
                                                     int pageSize,
                                                     @RequestParam(name = "page")
                                                     @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                                     int page);
    @GetMapping("/directors")
    HttpEntityResponse<List<PersonDTO>> getAllDirectors(@RequestParam(name = "page_size")
                                                        @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                                        @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
                                                        int pageSize,
                                                        @RequestParam(name = "page")
                                                        @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                                        int page);
    @GetMapping("/writers")
    HttpEntityResponse<List<PersonDTO>> getAllWriters(@RequestParam(name = "page_size")
                                                      @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                                      @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 100")
                                                      int pageSize,
                                                      @RequestParam(name = "page")
                                                      @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                                      int page);
}
