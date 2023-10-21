package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDTO {
    @NotNull(message = "Genre's id should not be null")
    private long id;

    @NotBlank(message = "Genre's name should contains at least one character")
    private String name;
}
