package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;

import java.util.List;

@RequestMapping("/persons")
@Validated
public interface PersonsController {

    @GetMapping("/{personId}")
    HttpEntityResponse<PersonDTO> findPersonById(@PathVariable("personId")
                                                @Min(value = 1, message = "Person id cannot be less than 1")
                                                long personId);

    @GetMapping("/by-imdb-id/{personId}")
    HttpEntityResponse<PersonDTO> findPersonByImdbId(@PathVariable("personId")
                                                    @Pattern(regexp = "nm\\d{7}", message = "Person's imdb id should match: nm1234567")
                                                    String personImdbId);

    @GetMapping("/by-name/{personName}")
    HttpEntityResponse<List<PersonDTO>> findPersonsByName(@PathVariable("personName") String personName);

    @GetMapping("/actors")
    HttpEntityResponse<List<PersonDTO>> findAllActors(@RequestParam(name = "page_size")
                                                     @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                                     int pageSize,
                                                     @RequestParam(name = "page")
                                                     @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                                     int page);
    @GetMapping("/directors")
    HttpEntityResponse<List<PersonDTO>> findAllDirectors(@RequestParam(name = "page_size")
                                                        @Min(value = 1, message = "Parameter 'page_size' cannot be less than 1")
                                                        int page,
                                                        @RequestParam(name = "page")
                                                        @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                                        int pageSize);
    @GetMapping("/writers")
    HttpEntityResponse<List<PersonDTO>> findAllWriters(@RequestParam(name = "page_size")
                                                      @Max(value = 100, message = "Parameter 'page_size' cannot be greater than 1")
                                                      int page,
                                                      @RequestParam(name = "page")
                                                      @Min(value = 0, message = "Parameter 'page' cannot be less than 0")
                                                      int pageSize);
}
