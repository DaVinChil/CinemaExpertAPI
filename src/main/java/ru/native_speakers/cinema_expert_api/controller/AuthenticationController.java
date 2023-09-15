package ru.native_speakers.cinema_expert_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.native_speakers.cinema_expert_api.dto.*;


@RequestMapping("/auth")
public interface AuthenticationController {

    @PostMapping("/register")
    HttpEntityResponse<JwtAuthenticationDTO> register(@Valid @RequestBody UserDTO userDTO);

    @PostMapping("/refresh-tokens")
    HttpEntityResponse<JwtAuthenticationDTO> refreshTokens(HttpServletRequest request);

    @PostMapping("/login")
    HttpEntityResponse<JwtAuthenticationDTO> login(@Valid @RequestBody AuthenticationDTO authenticationDTO);
}
