package com.example.msaccount_se181765.shared.exception;

public class AccountAlreadyExistException extends RuntimeException {
    public AccountAlreadyExistException(String message) {
        super("Account already exists!");
    }
}
