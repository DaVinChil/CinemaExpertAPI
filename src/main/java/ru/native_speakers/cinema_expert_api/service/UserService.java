package ru.native_speakers.cinema_expert_api.service;

import ru.native_speakers.cinema_expert_api.exception.RegistrationException;
import ru.native_speakers.cinema_expert_api.model.User;

public interface UserService {
    boolean isUserExists(String username);
    void save(User user) throws RegistrationException;
}
