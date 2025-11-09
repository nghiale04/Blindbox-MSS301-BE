package com.cloudgateway.config.jwt;

import io.jsonwebtoken.Claims;

public interface JwtProvider {
    boolean isExpired(String token);
    Claims parseToken(String token);
}
