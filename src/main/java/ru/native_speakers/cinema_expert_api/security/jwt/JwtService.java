package ru.native_speakers.cinema_expert_api.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.native_speakers.cinema_expert_api.dto.Token;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@Component
public class JwtService {
    @Value("${jwt_secret}")
    private String jwtSecret;

    @Value("${jwt_issuer}")
    private String jwtIssuer;

    @Value("${jwt_minutes_lifetime}")
    private long jwtMinutesLifetime;

    public Token generateToken(Map<String, Object> claims) {
        JWTCreator.Builder jwtBuilder = JWT.create();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            jwtBuilder.withClaim(entry.getKey(), entry.getValue().toString());
        }
        Date issuedAt = new Date();
        Date expiresAt = Date.from(ZonedDateTime.now().plusMinutes(jwtMinutesLifetime).toInstant());
        String jwtValue = jwtBuilder
                .withSubject(claims.get("username").toString())
                .withIssuer(jwtIssuer)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC256(jwtSecret));

        return Token.builder()
                .value(jwtValue)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .build();
    }

    public DecodedJWT decode(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(jwtSecret))
                .withIssuer(jwtIssuer)
                .build()
                .verify(token);
    }
}
