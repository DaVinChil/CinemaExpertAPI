package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.CharacterDTO;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.model.Character;
import ru.native_speakers.cinema_expert_api.service.CharactersService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharactersControllerImp implements CharactersController{
    private final CharactersService charactersService;

    public CharactersControllerImp(CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @Override
    public HttpEntityResponse<CharacterDTO> getCharacterById(long characterId) {
        return new HttpEntityResponse<>(convertCharacterToDto(charactersService.getCharacterByCharacterId(characterId)));
    }

    @Override
    public HttpEntityResponse<List<CharacterDTO>> getCharactersByName(String characterName) {
        return new HttpEntityResponse<>(convertListCharacterToDto(charactersService.getCharactersByName(characterName)));
    }

    public CharacterDTO convertCharacterToDto(Character character) {
        CharacterDTO dto = CharacterDTO.builder()
                .actorId(character.getActor().getId())
                .id(character.getId())
                .movieId(character.getMovie().getId())
                .name(character.getName())
                .build();
        return dto;
    }

    public List<CharacterDTO> convertListCharacterToDto(List<Character> characters){
        List<CharacterDTO> characterDTOS = new ArrayList<>(characters.size());
        characters.forEach(character -> characterDTOS.add(convertCharacterToDto(character)));
        return characterDTOS;
    }
}
