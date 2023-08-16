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
public class CharacterDTO {

    @NotNull(message = "Character's id should not be null")
    private int id;

    @NotBlank(message = "Character's name should contains at least one character")
    private String name;

    @NotNull(message = "Character's movie id should not be null")
    private int movieId;

    @NotNull(message = "Character's actor id should not be null")
    private int actorId;
}
