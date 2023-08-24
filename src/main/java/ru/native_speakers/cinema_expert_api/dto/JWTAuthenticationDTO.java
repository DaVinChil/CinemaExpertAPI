package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JWTAuthenticationDTO {
    @NotNull
    private String jwt;

    @NotNull
    private Date createdAt;
}
