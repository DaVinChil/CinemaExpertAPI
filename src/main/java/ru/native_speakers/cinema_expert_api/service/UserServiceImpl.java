package ru.native_speakers.cinema_expert_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.native_speakers.cinema_expert_api.exception.RegistrationException;
import ru.native_speakers.cinema_expert_api.model.User;
import ru.native_speakers.cinema_expert_api.repository.UserRepository;
import ru.native_speakers.cinema_expert_api.security.UserDetailsImpl;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    @Transactional
    public void save(User user) {
        if (isUserExists(user.getUsername())) {
            throw new RegistrationException("User with this username already exists");
        }
        user.setCreatedAt(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User with this username not found");
        }
        return new UserDetailsImpl(user.get());
    }
}
