package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.service.PersonsService;

import java.util.List;

import static ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO.convertPersonToPersonDTO;

@RestController
public class PersonsControllerImp implements PersonsController {

    private final PersonsService personsService;

    public PersonsControllerImp(PersonsService personsService) {
        this.personsService = personsService;
    }

    @Override
    public HttpEntityResponse<PersonDTO> findPersonById(long personId) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(personsService.getPersonByPersonId(personId)));
    }

    @Override
    public HttpEntityResponse<PersonDTO> findPersonByImdbId(String personImdbId) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(personsService.getPersonByImdbId(personImdbId)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findPersonsByName(String personName) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(personsService.getPersonsByName(personName)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findAllActors(int page, int pageSize) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(personsService.getAllActors(page, pageSize)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findAllDirectors(int page, int pageSize) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(personsService.getAllDirectors(page, pageSize)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> findAllWriters(int page, int pageSize) {
        return new HttpEntityResponse<>(convertPersonToPersonDTO(personsService.getAllWriters(page, pageSize)));
    }
}
