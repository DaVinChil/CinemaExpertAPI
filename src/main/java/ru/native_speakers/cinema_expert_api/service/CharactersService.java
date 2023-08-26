package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Character;

import java.util.List;
import java.util.Optional;

public interface CharactersService {
    Character getCharacterByCharacterId(long characterId) throws EntityNotFoundException;
    List<Character> getCharactersByName(String name) throws EntityNotFoundException;
}
