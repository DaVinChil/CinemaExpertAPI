package ru.native_speakers.cinema_expert_api.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.native_speakers.cinema_expert_api.exception.RegistrationException;
import ru.native_speakers.cinema_expert_api.model.User;

public interface UserService extends UserDetailsService {
    boolean isUserExists(String username);
    void save(User user) throws RegistrationException;
    void update(User user);
    User findUserByUsername(String username) throws UsernameNotFoundException;
    User findUserByRefreshToken(String refreshToken) throws UsernameNotFoundException;
}
