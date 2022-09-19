package com.example.demo.global.config;

import com.example.demo.domain.user.sevice.CustomAccountDetailsService;
import com.example.demo.global.common.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final CustomAccountDetailsService customAccountDetailsService;
    private final RedisService redisService;
    public void checkRefreshToken(String email, String accessToken) {

    }

    public String createAccessToken(String email, String role) {

    }

    public String createRefreshToken(String email, String role) {

    }
}
