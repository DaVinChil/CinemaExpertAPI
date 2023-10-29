package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.CharacterDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.service.CharactersService;

import java.util.List;

import static ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO.convertCharacterToCharacterDTO;

@RestController
public class CharactersControllerImpl implements CharactersController{
    private final CharactersService charactersService;

    public CharactersControllerImpl(@Qualifier("charactersServiceImpl") CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @Override
    public HttpEntityResponse<CharacterDTO> findCharacterById(long characterId) {
        return new HttpEntityResponse<>(convertCharacterToCharacterDTO(charactersService.findCharacterByCharacterId(characterId)));
    }

    @Override
    public HttpEntityResponse<List<CharacterDTO>> findCharactersByName(String characterName) {
        return new HttpEntityResponse<>(convertCharacterToCharacterDTO(charactersService.findCharactersByName(characterName)));
    }
}
