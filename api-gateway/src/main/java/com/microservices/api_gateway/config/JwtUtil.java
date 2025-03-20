package com.microservices.api_gateway.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parser()  // Usa parser() en lugar de parserBuilder()
                    .verifyWith(getSigningKey())  // Reemplaza setSigningKey() por verifyWith()
                    .build()
                    .parseSignedClaims(token)  // Reemplaza parseClaimsJws() por parseSignedClaims()
                    .getPayload();  // Ahora se usa getPayload() para obtener los Claims
        } catch (JwtException e) {
            throw new RuntimeException("Token inválido o expirado", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            extractAllClaims(token); // Si no lanza excepción, el token es válido
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class);
    }
}
