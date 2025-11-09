package com.example.msaccount_se181765.config.jwt;

import com.example.msaccount_se181765.entity.SystemAccounts;
import io.jsonwebtoken.Claims;

public interface JwtProvider {
    String issueAccessToken(SystemAccounts acc, String sessionId, String jti);
    Claims parse(String token);
}
