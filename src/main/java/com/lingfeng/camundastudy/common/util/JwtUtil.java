package com.lingfeng.camundastudy.common.util;

import com.lingfeng.camundastudy.common.constant.StringConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    // 1. 从配置文件读取密钥
    @Value("${jwt.secret}")
    private String secret;

    // 2. 从配置文件读取 Token 有效期
    @Value("${jwt.expiration}")
    private long expirationTime;

    // 获取签名密钥
    private Key getSigningKey() {
        // 使用固定的密钥字符串生成 Key 对象
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // 生成 Token
    public String generateToken(String username) {
        return StringConstant.TOKEN_PREFIX + Jwts.builder()
                .setSubject(username) // 主题（存用户名）
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 过期时间
                .signWith(getSigningKey()) // 签名
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
            log.error("Token 无效：", e);
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}