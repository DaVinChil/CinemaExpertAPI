package ru.native_speakers.cinema_expert_api.util.genre;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenresQueryParameters {
    @NotNull(message = "Parameter 'count' cannot be null")
    @Min(value = 0, message = "Parameter 'count' cannot be negative")
    private int count = 20;

    @Min(value = 1, message = "Parameter 'genreId' cannot be negative")
    private int genreId;
}
