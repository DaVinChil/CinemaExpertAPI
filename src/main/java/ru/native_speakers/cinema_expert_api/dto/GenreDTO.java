package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {

    @NotNull(message = "Genre's id should not be null")
    private int id;

    @NotNull(message = "Genre's name should not be null")
    @NotEmpty(message = "Genre's name should not be empty")
    private String name;
}
