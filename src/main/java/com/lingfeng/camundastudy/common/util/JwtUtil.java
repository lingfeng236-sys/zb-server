package com.lingfeng.camundastudy.common.util;

import com.lingfeng.camundastudy.common.constant.StringConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // 1. 定义秘钥（在真实项目中，这个应该放在配置文件里，且更长更复杂）
    // 必须足够长（至少256位），否则报错
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 2. Token 有效期（这里设为 1 小时）
    private static final long EXPIRATION_TIME = 3600_000;

    // 生成 Token
    public String generateToken(String username) {
        return StringConstant.TOKEN_PREFIX + Jwts.builder()
                .setSubject(username) // 主题（存用户名）
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 过期时间
                .signWith(key) // 签名
                .compact();
    }

    // 解析 Token 获取用户名
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    // 验证 Token 是否有效
    public boolean validateToken(String token) {
        try {
            parseClaims(token); // 如果解析失败或过期，会抛出异常
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}