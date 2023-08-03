package ru.native_speakers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    @NotNull(message = "Movie's imdb id should not be null")
    @NotEmpty(message = "Movie's imdb id should not be empty")
    @Pattern(regexp = "tt\\d{7}", message = "Movie's imdb id should be match: tt1234567")
    private String imdbId;

    @NotNull(message = "Movie's title should not be null")
    @NotEmpty(message = "Movie's title should not be empty")
    private String title;

    @NotNull(message = "Movie's description should not be null")
    private String description;

    @NotNull(message = "Movie's running should not be null")
    private int runningTimeInMinutes;

    @NotNull(message = "Movie's rating should not be null")
    private double chartRating;

    @NotNull(message = "Movie's year should not be null")
    private int year;

    @NotNull(message = "Movie's image should not be null")
    private ImageDTO image;

    @NotNull(message = "Movie's directors should not be null")
    private List<PersonDTO> directors;

    @NotNull(message = "Movie's writers should not be null")
    private List<PersonDTO> writers;

    @NotNull(message = "Movie's actors should not be null")
    private List<PersonDTO> actors;

    @NotNull(message = "Movie's characters should not be null")
    private List<CharacterDTO> characters;

    @NotNull(message = "Movie's genres should not be null")
    private List<GenreDTO> genres;

    public void addGenre(GenreDTO genre) {
        if(genres == null){
            genres = new ArrayList<>();
        }
        genres.add(genre);
    }
    public void addCharacter(CharacterDTO character){
        if(characters == null){
            characters = new ArrayList<>();
        }

        characters.add(character);
    }

    public void addActor(PersonDTO person){
        if(actors == null){
            actors = new ArrayList<>();
        }

        actors.add(person);
    }

    public void addDirector(PersonDTO person){
        if(directors == null){
            directors = new ArrayList<>();
        }

        directors.add(person);
    }

    public void addWriter(PersonDTO person){
        if(writers == null){
            writers = new ArrayList<>();
        }

        writers.add(person);
    }
}
