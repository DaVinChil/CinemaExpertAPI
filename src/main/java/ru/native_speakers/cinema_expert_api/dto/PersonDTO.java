package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {

    @NotNull(message = "Person's id should not be null")
    private long id;

    @NotBlank(message = "Person's imdb id should contains at least one character")
    @Pattern(regexp = "nm\\d{7}", message = "Person's imdb id should match: nm1234567")
    private String imdbId;

    @NotBlank(message = "Person's full name should contains at least one character")
    private String fullName;

    private String gender;
    private double height;
    private Date birthday;
    private String birthPlace;
    private Date deathDate;
    private String deathPlace;
    private String deathCause;

    @NotNull(message = "Person's photo should not be null")
    private ImageDTO photo;

    private List<Long> charactersId;
    private List<Long> moviesAsActor;
    private List<Long> moviesAsWriter;
    private List<Long> moviesAsDirector;
}
