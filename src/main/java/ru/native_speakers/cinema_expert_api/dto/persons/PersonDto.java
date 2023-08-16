package ru.native_speakers.cinema_expert_api.dto.persons;

import lombok.Builder;
import lombok.Data;
import ru.native_speakers.cinema_expert_api.model.Image;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class PersonDto {
    private String imdbId;
    private String fullName;
    private String gender;
    private double height;
    private Date birthday;
    private String birthPlace;
    private Date deathDate;
    private String deathCause;
    private String deathPlace;
    private Image photo;
    private List<CharacterDto> characters;
    private List<String> filmography;
}


