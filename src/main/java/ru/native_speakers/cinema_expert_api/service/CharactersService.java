package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Character;

import java.util.List;

public interface CharactersService {
    Character findCharacterByCharacterId(long characterId) throws EntityNotFoundException;
    List<Character> findCharactersByName(String name) throws EntityNotFoundException;
}
