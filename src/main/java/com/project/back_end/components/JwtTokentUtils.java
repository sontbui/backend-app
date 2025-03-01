package com.project.back_end.components;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Base64.Decoder;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import com.project.back_end.models.Token;
import com.project.back_end.models.User;
import com.project.back_end.repositories.TokenRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokentUtils {

    @Value("${jwt.expiration}")
    private int expiration;

    @Value("${jwt.secret}")
    private String secret;

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JwtTokentUtils.class);// private final Token
    private final TokenRepository tokenRepository;

    public String generateToken(com.project.back_end.models.User user) throws Exception {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("phone", user.getPhone());
        claims.put("_id", user.getId());
        try {
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getPhone())
                    .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                    .signWith(getSignInkey(), SignatureAlgorithm.HS512)
                    .compact();
            return token;
        } catch (Exception e) {
            logger.error("Error generating token: ", e);
            throw new Exception("Error generating token: " + e.getMessage());
        }
    }

    private Key getSignInkey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = this.extractClaim(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    public String extractPhone(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean validateTokenPhone(String token, User userDetails){
        try{
            String phone = extractPhone(token);
            Token existingToken = tokenRepository.findByToken(token);
            if(existingToken == null || 
            existingToken.isRevoked() == true || 
            !userDetails.isActive()
            ){
                return false;
            }
            return (phone.equals(userDetails.getPhone())) && !isTokenExpired(token);
        }catch (MalformedJwtException e){
            logger.error("Invalid JWT token: {}", e.getMessage());
        }catch(ExpiredJwtException e){
            logger.error("Expired JWT token: {}", e.getMessage());
        }catch(UnsupportedJwtException e){
            logger.error("JWT token is unsupported: {}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public boolean validateTokenEmail(String token, User userDetails){
        try{
            String email = extractPhone(token);
            Token existingToken = tokenRepository.findByToken(token);
            if(existingToken == null || 
            existingToken.isRevoked() == true || 
            !userDetails.isActive()
            ){
                return false;
            }
            return (email.equals(userDetails.getEmail())) && !isTokenExpired(token);
        }catch (MalformedJwtException e){
            logger.error("Invalid JWT token: {}", e.getMessage());
        }catch(ExpiredJwtException e){
            logger.error("Expired JWT token: {}", e.getMessage());
        }catch(UnsupportedJwtException e){
            logger.error("JWT token is unsupported: {}", e.getMessage());
        }catch(IllegalArgumentException e){
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}
