package ru.native_speakers.cinema_expert_api.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JWTCore {
    @Value("${jwt_secret}")
    private String JWTSecret;

    @Value("${jwt_subject}")
    private String JWTSubject;

    @Value("${jwt_issuer}")
    private String JWTIssuer;

    @Value("${jwt_days_lifetime}")
    private long JWTDaysLifetime;

    public String generateToken(JWTModel jwtModel) {
        Date expirationDate = Date.from(ZonedDateTime.now().plusDays(JWTDaysLifetime).toInstant());
        return JWT.create()
                .withSubject(JWTSubject)
                .withClaim("username", jwtModel.getUsername())
                .withIssuedAt(new Date())
                .withIssuer(JWTIssuer)
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(JWTSecret));
    }

    public JWTModel retrieveValues(String token) throws JWTVerificationException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWTSecret))
                .withSubject("User details")
                .withIssuer("Cinema Expert API")
                .build();


        DecodedJWT jwt = jwtVerifier.verify(token);
        return JWTModel.builder().username(jwt.getClaim("username").asString()).build();
    }
}
