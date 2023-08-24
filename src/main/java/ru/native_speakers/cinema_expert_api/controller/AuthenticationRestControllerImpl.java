package ru.native_speakers.cinema_expert_api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import ru.native_speakers.cinema_expert_api.dto.*;
import ru.native_speakers.cinema_expert_api.model.User;
import ru.native_speakers.cinema_expert_api.security.jwt.JWTCore;
import ru.native_speakers.cinema_expert_api.security.jwt.JWTModel;
import ru.native_speakers.cinema_expert_api.service.UserService;

import java.util.Date;

@RestController
public class AuthenticationRestControllerImpl implements AuthenticationController {

    private final AuthenticationProvider authenticationProvider;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final JWTCore jwtCore;

    public AuthenticationRestControllerImpl(@Qualifier("userServiceImpl") UserService userService,
                                            ModelMapper modelMapper, JWTCore jwtCore,
                                            @Qualifier("daoAuthenticationProvider") AuthenticationProvider authenticationProvider) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.jwtCore = jwtCore;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public HttpEntityResponse<JWTAuthenticationDTO> signup(UserDTO userDTO) {
        userService.save(convertUserDTOToUser(userDTO));

        JWTModel jwtModel = JWTModel.builder().username(userDTO.getUsername()).build();
        JWTAuthenticationDTO authDTO = JWTAuthenticationDTO.builder()
                .jwt(jwtCore.generateToken(jwtModel))
                .createdAt(new Date()).build();
        return new HttpEntityResponse<>(authDTO);
    }

    @Override
    public HttpEntityResponse<JWTAuthenticationDTO> signin(AuthenticationDTO authenticationDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationDTO.getUsername(), authenticationDTO.getPassword()
        );
        authenticationProvider.authenticate(authenticationToken);

        JWTModel jwtModel = JWTModel.builder().username(authenticationDTO.getUsername()).build();
        JWTAuthenticationDTO authDTO = JWTAuthenticationDTO.builder()
                .jwt(jwtCore.generateToken(jwtModel))
                .createdAt(new Date()).build();
        return new HttpEntityResponse<>(authDTO);
    }

    @Override
    public User convertUserDTOToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
