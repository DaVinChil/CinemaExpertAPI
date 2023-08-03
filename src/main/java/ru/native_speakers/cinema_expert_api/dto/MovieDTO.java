package ru.native_speakers.cinema_expert_api.dto;

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

    @NotNull(message = "MovieDTO id should not be null")
    private int id;

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

    @NotNull(message = "Movie's directors id should not be null")
    private List<Integer> directorsId;

    @NotNull(message = "Movie's writers id should not be null")
    private List<Integer> writersId;

    @NotNull(message = "Movie's actors id should not be null")
    private List<Integer> actorsId;

    @NotNull(message = "Movie's characters id should not be null")
    private List<Integer> charactersId;

    @NotNull(message = "Movie's genres should not be null")
    private List<GenreDTO> genres;

    public void addDirectorId(int directorId) {
        if (directorsId == null) {
            directorsId = new ArrayList<>();
        }
        directorsId.add(directorId);
    }

    public void addWriterId(int writerId) {
        if (writersId == null) {
            writersId = new ArrayList<>();
        }
        writersId.add(writerId);
    }

    public void addActorId(int actorId) {
        if (actorsId == null) {
            actorsId = new ArrayList<>();
        }
        actorsId.add(actorId);
    }

    public void addCharacterId(int characterId) {
        if (charactersId == null) {
            charactersId = new ArrayList<>();
        }
        charactersId.add(characterId);
    }
}
