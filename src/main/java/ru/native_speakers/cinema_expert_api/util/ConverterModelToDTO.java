package ru.native_speakers.cinema_expert_api.util;

import ru.native_speakers.cinema_expert_api.dto.*;
import ru.native_speakers.cinema_expert_api.model.*;
import ru.native_speakers.cinema_expert_api.model.Character;

import java.util.List;

public class ConverterModelToDTO {
    public static MovieDTO convertMovieToMovieDTO(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .imdbId(movie.getImdbId())
                .title(movie.getTitle())
                .chartRating(movie.getChartRating())
                .runningTimeInMinutes(movie.getRunningTimeInMinutes())
                .description(movie.getDescription())
                .year(movie.getYear())
                .image(convertImageToImageDTO(movie.getImage()))
                .actorsId(movie.getActors().stream().map(Person::getId).toList())
                .directorsId(movie.getDirectors().stream().map(Person::getId).toList())
                .writersId(movie.getWriters().stream().map(Person::getId).toList())
                .genres(convertGenreToGenreDTO(movie.getGenres()))
                .charactersId(movie.getCharacters().stream().map(Character::getId).toList())
                .build();
    }

    public static List<MovieDTO> convertMovieToMovieDTO(List<Movie> movies) {
        return movies.stream().map(ConverterModelToDTO::convertMovieToMovieDTO).toList();
    }

    public static PersonDTO convertPersonToPersonDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .imdbId(person.getImdbId())
                .fullName(person.getFullName())
                .birthday(person.getBirthday())
                .birthPlace(person.getBirthPlace())
                .deathDate(person.getDeathDate())
                .deathCause(person.getDeathCause())
                .deathPlace(person.getDeathPlace())
                .gender(person.getGender())
                .photo(convertImageToImageDTO(person.getPhoto()))
                .height(person.getHeight())
                .moviesAsActor(person.getMoviesAsActor().stream().map(Movie::getId).toList())
                .moviesAsWriter(person.getMoviesAsWriter().stream().map(Movie::getId).toList())
                .moviesAsDirector(person.getMoviesAsDirector().stream().map(Movie::getId).toList())
                .charactersId(person.getCharacters().stream().map(Character::getId).toList())
                .build();
    }

    public static List<PersonDTO> convertPersonToPersonDTO(List<Person> persons) {
        return persons.stream().map(ConverterModelToDTO::convertPersonToPersonDTO).toList();
    }

    public static CharacterDTO convertCharacterToCharacterDTO(Character character) {
        return CharacterDTO.builder()
                .actorId(character.getActor().getId())
                .id(character.getId())
                .movieId(character.getMovie().getId())
                .name(character.getName())
                .build();
    }

    public static List<CharacterDTO> convertCharacterToCharacterDTO(List<Character> characters) {
        return characters.stream().map(ConverterModelToDTO::convertCharacterToCharacterDTO).toList();
    }

    public static ImageDTO convertImageToImageDTO(Image image) {
        return ImageDTO.builder()
                .id(image.getId())
                .width(image.getWidth())
                .height(image.getHeight())
                .url(image.getUrl())
                .build();
    }

    public static List<ImageDTO> convertImageToImageDTO(List<Image> images) {
        return images.stream().map(ConverterModelToDTO::convertImageToImageDTO).toList();
    }

    public static GenreDTO convertGenreToGenreDTO(Genre genre) {
        return GenreDTO.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    public static List<GenreDTO> convertGenreToGenreDTO(List<Genre> genres) {
        return genres.stream().map(ConverterModelToDTO::convertGenreToGenreDTO).toList();
    }
}
