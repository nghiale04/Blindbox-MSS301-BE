package com.example.msaccount_se181765.shared.exception;


public class PasswordNotMatchException extends RuntimeException {
    public PasswordNotMatchException(String message) {
        super("Passwords and confirmation do not match!");
    }
}
