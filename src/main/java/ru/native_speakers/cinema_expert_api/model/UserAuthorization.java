package ru.native_speakers.cinema_expert_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "user_authorization")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorization_id")
    private long id;

    @Column(name = "refresh_token")
    @NotNull
    private String refreshToken;

    @Column(name = "refresh_token_expires_at")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date refreshTokenExpiresAt;
}
