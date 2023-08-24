package ru.native_speakers.cinema_expert_api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.native_speakers.cinema_expert_api.dto.*;
import ru.native_speakers.cinema_expert_api.model.User;


@RequestMapping("/auth")
public interface AuthenticationController {

    @PostMapping("/signup")
    HttpEntityResponse<JWTAuthenticationDTO> signup(@Valid @RequestBody UserDTO userDTO);

    @PostMapping("/signin")
    HttpEntityResponse<JWTAuthenticationDTO> signin(@Valid @RequestBody AuthenticationDTO authenticationDTO);

    User convertUserDTOToUser(UserDTO userDTO);
}
