package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

    @NotNull(message = "Character's name should not be null")
    @NotEmpty(message = "Character's name should not be empty")
    private String name;

    @NotNull(message = "Character's movie should not be null")
    private MovieDTO movie;

    @NotNull(message = "Character's actor should not be null")
    private PersonDTO actor;
}
