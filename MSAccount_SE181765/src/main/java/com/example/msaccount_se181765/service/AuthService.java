package com.example.msaccount_se181765.service;

import com.example.msaccount_se181765.dto.request.LoginRequest;
import com.example.msaccount_se181765.dto.request.RegisterRequest;
import com.example.msaccount_se181765.dto.response.AuthResponse;
import com.example.msaccount_se181765.entity.SystemAccounts;

public interface AuthService {
    AuthResponse login(LoginRequest loginRequest) throws Exception;
    SystemAccounts register(RegisterRequest registerRequest);
}
