package com.example.msaccount_se181765.service;

import com.example.msaccount_se181765.config.jwt.JwtProvider;
import com.example.msaccount_se181765.dto.request.LoginRequest;
import com.example.msaccount_se181765.dto.request.RegisterRequest;
import com.example.msaccount_se181765.dto.response.AuthResponse;
import com.example.msaccount_se181765.entity.SystemAccounts;
import com.example.msaccount_se181765.enums.RoleName;
import com.example.msaccount_se181765.repository.SystemAccountRepository;
import com.example.msaccount_se181765.shared.exception.AccountAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService {
    private final SystemAccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    @Override
    public AuthResponse login(LoginRequest loginRequest) throws Exception {
        try {
            SystemAccounts acc = accountRepository.findByEmail(loginRequest.getGmail())
                    .orElseThrow(() -> new UsernameNotFoundException("Incorrrect user name or password. Please check again."));

            if (!acc.getIsActive()) {
                throw new UsernameNotFoundException("Account is disabled or locked");
            }
            if (!Objects.equals(loginRequest.getPassword(), acc.getPassword())) {
                throw new UsernameNotFoundException("Incorrrect user name or password. Please check again.");
            }

            String sessionId = UUID.randomUUID().toString();
            String jti = UUID.randomUUID().toString();

            String access = jwtProvider.issueAccessToken(acc, sessionId, jti);

            return new AuthResponse(access);
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @Override
    public SystemAccounts register(RegisterRequest registerRequest) {
        try {
            SystemAccounts account = accountRepository.findByEmail(registerRequest.getGmail()).orElse(null);
            if (account != null) {
                throw new AccountAlreadyExistException(account.getEmail() + " already exists!");
            }

            SystemAccounts newAccount = SystemAccounts.builder()
                    .email(registerRequest.getGmail())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .role(RoleName.Member)
                    .isActive(true)
                    .build();

            return accountRepository.save(newAccount);
        } catch (Exception e) {
            throw new AccountAlreadyExistException(e.getMessage());
        }
    }
}
