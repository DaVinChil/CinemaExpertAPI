package ru.native_speakers.cinema_expert_api.service;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;
import ru.native_speakers.cinema_expert_api.exception.EntityNotFoundException;
import ru.native_speakers.cinema_expert_api.model.Character;
import ru.native_speakers.cinema_expert_api.repository.CharactersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImp implements CharactersService {

    private final CharactersRepository charactersRepository;

    public CharacterServiceImp(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @Override
    public Character getCharacterById(int id) {
        return charactersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No such character by given id"));
    }

    @Override
    public List<Character> getCharactersByName(String name) {
        List<Character> characters = charactersRepository.findByNameContains(name);
        if(characters.isEmpty()) {
            throw new EntityNotFoundException("No such character by given name");
        }
        return characters;
    }
}
