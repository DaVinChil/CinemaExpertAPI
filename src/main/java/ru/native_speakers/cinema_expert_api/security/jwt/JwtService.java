package ru.native_speakers.cinema_expert_api.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.native_speakers.cinema_expert_api.security.Token;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

@Component
public class JwtService {

    @Value("${jwt_secret}")
    private String jwtSecret;

    @Value("${jwt_issuer}")
    private String jwtIssuer;

    @Value("${jwt_days_lifetime}")
    private long jwtDaysLifetime;

    public Token generateToken(Map<String, Object> claims) {
        JWTCreator.Builder jwtBuilder = JWT.create();
        for (Map.Entry<String, Object> claim : claims.entrySet()) {
            jwtBuilder.withClaim(claim.getKey(), claim.getValue().toString());
        }
        Date issuedAt = new Date();
        Date expirationDate = Date.from(ZonedDateTime.now().plusDays(jwtDaysLifetime).toInstant());
        String jwt = jwtBuilder
                .withSubject(claims.get("username").toString())
                .withIssuer(jwtIssuer)
                .withIssuedAt(issuedAt)
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(jwtSecret));

        return Token.builder()
                .value(jwt)
                .issuedAt(issuedAt)
                .expiresAt(expirationDate)
                .build();
    }

    public DecodedJWT decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtSecret))
                .withIssuer(jwtIssuer)
                .build()
                .verify(token);
    }
}
