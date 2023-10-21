package ru.native_speakers.cinema_expert_api.authentication.security;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    @NotNull
    private String value;

    @NotNull
    private Date issuedAt;

    @NotNull
    private Date expiresAt;
}
