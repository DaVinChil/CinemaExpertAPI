package ru.native_speakers.cinema_expert_api.dto.persons;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.native_speakers.cinema_expert_api.model.Character;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

@Data
@Builder
public class MovieByPerson {
    private String role;
    private int ceId;
    private String imdbId;
    private String title;
    private String description;
    private int runningTimeInMinutes;
    private double chartRating;
    private int year;
    private ImageDto image;
    private List<GenreDto> genres;
}
