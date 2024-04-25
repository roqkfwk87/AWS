package com.estate.back.provider;

import java.security.Key;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// Jwt 생성 및 검증 제공자 
// - JWT 암호화 알고리즘 HS256
// - 비밀키는 환경변수에 있는 jwt.secret-key
// - JWT 만료 기간 10시간 
// 1000 (이후 1시간)

@Component
public class JwtProvider {
    
    @Value("${jwt.secret-key}")
    private String secretKey;

    // private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    
    // JWT 생성 메서드 
    public String create (String userId) {
        
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        // 만료일 = 현재시간 + 10시간 
        Date expiredDate = Date.from(Instant.now().plus(10, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
            .signWith(key, SignatureAlgorithm.HS256)
            .setSubject(userId)
            .setIssuedAt(new Date())
            .setExpiration(expiredDate)
            .compact();

        return jwt;
    } 

    // JWT 검증 메서드

    // 검증할 jwt를 외부에서 받아옴
    public String validate (String jwt) {
        
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        
        // 반환할 변수 생성
        String userId = null;

        // 해체 작업 시작 
        try {
            userId = Jwts.parserBuilder()
                // key 생성
                .setSigningKey(key)
                .build()
                // key 안에 jwt를 넣음
                .parseClaimsJws(jwt)
                // 해체 작업 시작
                .getBody()
                .getSubject();
        }catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        
        return userId;
    
    }

}
