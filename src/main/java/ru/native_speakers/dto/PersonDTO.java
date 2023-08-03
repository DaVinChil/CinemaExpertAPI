package ru.native_speakers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @NotNull(message = "Person's imdb id should not be null")
    @NotEmpty(message = "Person's imdb id should not be empty")
    @Pattern(regexp = "nm\\d{7}", message = "Person's imdb id should match: nm1234567")
    private String imdbId;

    @NotNull(message = "Person's full name should not be null")
    @NotEmpty(message = "Person's full name should not be empty")
    private String fullName;

    private String gender;
    private double height;
    private Date birthday;
    private String birthPlace;
    private Date deathDate;
    private String deathCause;
    private String deathPlace;

    @NotNull(message = "Person's photo should not be null")
    private ImageDTO photo;

    private List<CharacterDTO> characters;
    private List<MovieDTO> filmography;

    public void addCharacter(CharacterDTO character){
        if(characters == null){
            characters = new ArrayList<>();
        }

        characters.add(character);
    }
}
