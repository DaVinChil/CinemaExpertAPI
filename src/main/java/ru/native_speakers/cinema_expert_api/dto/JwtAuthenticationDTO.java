package ru.native_speakers.cinema_expert_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationDTO {
    private Token jwt;
    private Token refreshToken;
}
