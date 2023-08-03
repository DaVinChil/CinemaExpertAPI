package ru.native_speakers.dto;

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
    private String imdbId;
    private String fullName;
    private String gender;
    private double height;
    private Date birthday;
    private String birthPlace;
    private Date deathDate;
    private String deathCause;
    private String deathPlace;
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
