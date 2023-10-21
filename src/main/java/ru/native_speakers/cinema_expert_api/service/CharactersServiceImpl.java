package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Character;
import ru.native_speakers.cinema_expert_api.repository.CharactersRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharactersServiceImpl implements CharactersService {
    private final CharactersRepository charactersRepository;

    @Override
    public Character findCharacterByCharacterId(long characterId) throws EntityNotFoundException {
        return charactersRepository.findById(characterId).orElseThrow(() -> new EntityNotFoundException("No such character by given id"));
    }

    @Override
    public List<Character> findCharactersByName(String name) throws EntityNotFoundException {
        List<Character> characters = charactersRepository.findByNameContains(name);
        if(characters.isEmpty()) {
            throw new EntityNotFoundException("No such character by given name");
        }
        return characters;
    }
}
