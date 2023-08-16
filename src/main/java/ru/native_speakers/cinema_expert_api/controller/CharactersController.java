package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.native_speakers.cinema_expert_api.dto.CharacterDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;

import java.util.List;

@RequestMapping("/character")
public interface CharactersController {
    @GetMapping("/character-by-id/{id}")
    HttpEntityResponse<CharacterDTO> getCharacterById(@PathVariable("id") int characterId);
    @GetMapping("/character-by-name/{name}")
    HttpEntityResponse<List<CharacterDTO>> getCharactersByName(@PathVariable("name") String characterName);
}
