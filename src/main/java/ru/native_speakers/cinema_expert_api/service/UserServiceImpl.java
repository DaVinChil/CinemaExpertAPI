package ru.native_speakers.cinema_expert_api.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
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
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean isUserExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    @Transactional
    public void save(User user) throws RegistrationException {
        if (isUserExists(user.getUsername())) {
            throw new RegistrationException("User with this username already exists");
        }
        user.setCreatedAt(new Date());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User with this username not found")
        );
    }

    @Override
    public User findUserByRefreshToken(String refreshToken) throws UsernameNotFoundException {
        return userRepository.findUserByRefreshToken(refreshToken).orElseThrow(() -> new UsernameNotFoundException("Invalid refresh token"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User with this username not found");
        }
        return new UserDetailsImpl(user.get());
    }
}
