package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {
    @NotNull(message = "MovieDTO id should not be null")
    private long id;

    @NotBlank(message = "Movie's imdb id should contains at least one character")
    @Pattern(regexp = "tt\\d{7}", message = "Movie's imdb id should be match: tt1234567")
    private String imdbId;

    @NotBlank(message = "Movie's title should contains at least one character")
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

    @NotEmpty(message = "Movie's director's id should contains at least one director id")
    private List<Long> directorsId;

    @NotEmpty(message = "Movie's writer's id should contains at least one writer id")
    private List<Long> writersId;

    @NotEmpty(message = "Movie's actor's id should contains at least one actor's id")
    private List<Long> actorsId;

    @NotEmpty(message = "Movie's character's id should contains at least one character's id")
    private List<Long> charactersId;

    @NotEmpty(message = "Movie's genre's id should contains at least one genre's id")
    private List<GenreDTO> genres;
}
