package com.br.myproject.users.infraestructure.configuration.handlers;

import com.br.myproject.users.domain.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String KEY = "secretKey";  // Use uma chave melhor em produção!

    public static String generateToken(User user) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + 3600000; // Token válido por 1 hora
        Date exp = new Date(expMillis);

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name()); // Inclui a role do usuário como uma claim

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }
}
