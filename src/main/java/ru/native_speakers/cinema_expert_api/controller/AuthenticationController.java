package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.native_speakers.cinema_expert_api.dto.*;
import ru.native_speakers.cinema_expert_api.model.User;


@RequestMapping("/auth")
public interface AuthenticationController {

    @PostMapping("/registration")
    HttpEntityResponse<JWTAuthenticationDTO> register(@Valid @RequestBody UserDTO userDTO);

    @PostMapping("/login")
    HttpEntityResponse<JWTAuthenticationDTO> login(@Valid @RequestBody AuthenticationDTO authenticationDTO);

    User convertUserDTOToUser(UserDTO userDTO);
}
