package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.PersonDTO;
import ru.native_speakers.cinema_expert_api.model.Person;
import ru.native_speakers.cinema_expert_api.service.PersonsService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonsControllerImp implements PersonsController{
    private final PersonsService personsService;

    public PersonsControllerImp(PersonsService personsService) {
        this.personsService = personsService;
    }

    @Override
    public HttpEntityResponse<PersonDTO> getPersonById(int personId) {
        return new HttpEntityResponse<>(convertPersonToDto(personsService.getPersonById(personId)));
    }

    @Override
    public HttpEntityResponse<PersonDTO> getPersonByImdbId(String personId) {
        return new HttpEntityResponse<>(convertPersonToDto(personsService.getPersonByImdbId(personId)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getPersonsByName(String personName) {
        return new HttpEntityResponse<>(convertListPersonsToDto(personsService.getPersonsByName(personName)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getAllActors(int page, int pageSize) {
        return new HttpEntityResponse<>(convertListPersonsToDto(personsService.getAllActors(page, pageSize)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getAllDirectors(int page, int pageSize) {
        return new HttpEntityResponse<>(convertListPersonsToDto(personsService.getAllDirectors(page, pageSize)));
    }

    @Override
    public HttpEntityResponse<List<PersonDTO>> getAllWriters(int page, int pageSize) {
        return new HttpEntityResponse<>(convertListPersonsToDto(personsService.getAllWriters(page, pageSize)));
    }

    public PersonDTO convertPersonToDto(Person person){
        PersonDTO personDto = PersonDTO.builder()
                .deathCause(person.getDeathCause())
                .birthday(person.getBirthday())
                .birthPlace(person.getBirthPlace())
                .charactersId(person.getCharacters().stream().map(character -> character.getId()).collect(Collectors.toList()))
                .deathDate(person.getDeathDate())
                .deathPlace(person.getDeathPlace())
                .fullName(person.getFullName())
                .gender(person.getGender())
                .personId(person.getId())
                .height(person.getHeight())
                .imdbId(person.getImdbId())
                .moviesAsActor(person.getMoviesAsActor().stream().map(movie -> movie.getId()).collect(Collectors.toList()))
                .moviesAsDirector(person.getMoviesAsDirector().stream().map(movie -> movie.getId()).collect(Collectors.toList()))
                .moviesAsWriter(person.getMoviesAsWriter().stream().map(movie -> movie.getId()).collect(Collectors.toList())).build();
        return personDto;
    }

    public List<PersonDTO> convertListPersonsToDto(List<Person> persons) {
        List<PersonDTO> personDTOS = new ArrayList<>(persons.size());
        persons.forEach(person -> personDTOS.add(convertPersonToDto(person)));
        return personDTOS;
    }
}
