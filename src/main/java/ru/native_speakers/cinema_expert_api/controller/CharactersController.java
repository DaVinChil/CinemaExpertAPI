package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.native_speakers.cinema_expert_api.dto.CharacterDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;

import java.util.List;

@RequestMapping("/characters")
@Validated
public interface CharactersController {

    @GetMapping("/{id}")
    HttpEntityResponse<CharacterDTO> getCharacterById(@PathVariable("id")
                                                      @Min(value = 1, message = "Character's id cannot be less than 1")
                                                      long characterId);

    @GetMapping("/by-name/{name}")
    HttpEntityResponse<List<CharacterDTO>> getCharactersByName(@PathVariable("name") String characterName);
}
