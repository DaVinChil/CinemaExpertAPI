package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.native_speakers.cinema_expert_api.authentication.security.Token;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JWTAuthenticationDTO {
    @NotNull
    private Token jwt;
}
