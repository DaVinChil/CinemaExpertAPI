package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.*;
import ru.native_speakers.cinema_expert_api.authentication.security.Token;
import ru.native_speakers.cinema_expert_api.authentication.jwt.JwtService;
import ru.native_speakers.cinema_expert_api.service.UserService;
import ru.native_speakers.cinema_expert_api.util.ConverterModelToDTO;

import java.util.Map;

@RestController
public class AuthenticationRestControllerImpl implements AuthenticationController {
    private final AuthenticationProvider authenticationProvider;
    private final UserService userService;
    private final JwtService jwtService;

    public AuthenticationRestControllerImpl(
            @Qualifier("userServiceImpl") UserService userService,
            JwtService jwtService,
            @Qualifier("daoAuthenticationProvider") AuthenticationProvider authenticationProvider
    ) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public HttpEntityResponse<JWTAuthenticationDTO> signup(UserDTO userDTO) {
        userService.save(ConverterModelToDTO.convertUserDTOToUser(userDTO));
        Token jwt = jwtService.generateToken(
                Map.of("username", userDTO.getUsername())
        );
        return new HttpEntityResponse<>(new JWTAuthenticationDTO(jwt));
    }

    @Override
    public HttpEntityResponse<JWTAuthenticationDTO> signin(AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationDTO.getUsername(), authenticationDTO.getPassword()
        );
        authenticationProvider.authenticate(authenticationToken);

        Token jwt = jwtService.generateToken(
                Map.of("username", authenticationDTO.getUsername())
        );
        return new HttpEntityResponse<>(new JWTAuthenticationDTO(jwt));
    }
}
