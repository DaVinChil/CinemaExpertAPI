package ru.native_speakers.cinema_expert_api.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationDTO {
    @Size(min = 4, message = "Username should have at least 4 characters")
    private String username;

    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;
}
