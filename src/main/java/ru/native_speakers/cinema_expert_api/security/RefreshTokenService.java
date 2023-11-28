package ru.native_speakers.cinema_expert_api.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.native_speakers.cinema_expert_api.dto.Token;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Component
@Data
@RequiredArgsConstructor
public class RefreshTokenService {

    @Value("${refresh_token_days_lifetime}")
    private long refreshTokenDaysLifetime;

    public Token generateToken(String username) {
        return Token.builder()
                .value(UUID.fromString(username).toString())
                .issuedAt(new Date())
                .expiresAt(Date.from(ZonedDateTime.now().plusDays(refreshTokenDaysLifetime).toInstant()))
                .build();
    }
}
