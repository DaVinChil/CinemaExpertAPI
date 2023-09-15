package ru.native_speakers.cinema_expert_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.*;
import ru.native_speakers.cinema_expert_api.model.User;
import ru.native_speakers.cinema_expert_api.model.UserAuthorization;
import ru.native_speakers.cinema_expert_api.security.RefreshTokenService;
import ru.native_speakers.cinema_expert_api.security.jwt.JwtService;
import ru.native_speakers.cinema_expert_api.service.UserService;

import java.util.Map;

@RestController
public class AuthenticationRestControllerImpl implements AuthenticationController {

    private final RefreshTokenService refreshTokenService;
    private final AuthenticationProvider authenticationProvider;
    private final UserService userService;
    private final JwtService jwtService;

    public AuthenticationRestControllerImpl(@Qualifier("userServiceImpl") UserService userService,
                                            JwtService jwtService,
                                            @Qualifier("daoAuthenticationProvider") AuthenticationProvider authenticationProvider,
                                            RefreshTokenService refreshTokenService
    ) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationProvider = authenticationProvider;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    public HttpEntityResponse<JwtAuthenticationDTO> register(UserDTO userDTO) {
        Token refreshToken = refreshTokenService.generateToken(userDTO.getUsername());
        UserAuthorization authorization = UserAuthorization.builder()
                .refreshToken(refreshToken.getValue())
                .refreshTokenExpiresAt(refreshToken.getExpiresAt())
                .build();

        User user = convertUserDTOToUser(userDTO);
        user.setAuthorization(authorization);
        userService.save(user);

        Token jwt = jwtService.generateToken(
                Map.of("username", user.getUsername())
        );

        return new HttpEntityResponse<>(new JwtAuthenticationDTO(jwt, refreshToken));
    }

    @Override
    public HttpEntityResponse<JwtAuthenticationDTO> refreshTokens(HttpServletRequest request) {
        String refreshToken = request.getHeader("refresh-token");
        if (refreshToken == null) {
            throw new UsernameNotFoundException("Invalid refresh token");
        }
        User user = userService.findUserByRefreshToken(refreshToken);

        Token newJwt = jwtService.generateToken(
                Map.of("username", user.getUsername())
        );
        Token newRefreshToken = refreshTokenService.generateToken(user.getUsername());
        user.getAuthorization().setRefreshToken(newRefreshToken.getValue());
        user.getAuthorization().setRefreshTokenExpiresAt(newRefreshToken.getExpiresAt());
        userService.update(user);
        return new HttpEntityResponse<>(new JwtAuthenticationDTO(newJwt, newRefreshToken));
    }

    @Override
    public HttpEntityResponse<JwtAuthenticationDTO> login(AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationDTO.getUsername(), authenticationDTO.getPassword()
        );
        authenticationProvider.authenticate(authenticationToken);

        Token jwt = jwtService.generateToken(
                Map.of("username", authenticationDTO.getUsername()
                ));
        User user = userService.findUserByUsername(authenticationDTO.getUsername());
        Token refreshToken = refreshTokenService.generateToken(user.getUsername());
        user.getAuthorization().setRefreshToken(refreshToken.getValue());
        user.getAuthorization().setRefreshTokenExpiresAt(refreshToken.getExpiresAt());
        userService.update(user);

        return new HttpEntityResponse<>(new JwtAuthenticationDTO(jwt, refreshToken));
    }

    public User convertUserDTOToUser(UserDTO userDTO) {
        return User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
    }
}
