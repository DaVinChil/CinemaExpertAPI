package ru.native_speakers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.native_speakers.model.Character;
import ru.native_speakers.model.Genre;
import ru.native_speakers.model.Person;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private String imdbId;
    private String title;
    private String description;
    private int runningTimeInMinutes;
    private double chartRating;
    private int year;
    private ImageDTO image;
    private List<PersonDTO> directors;
    private List<PersonDTO> writers;
    private List<PersonDTO> actors;
    private List<CharacterDTO> characters;
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
