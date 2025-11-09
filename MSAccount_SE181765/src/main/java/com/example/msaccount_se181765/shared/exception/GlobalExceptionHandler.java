package com.example.msaccount_se181765.shared.exception;

import com.example.msaccount_se181765.shared.dto.ErrorResponse;
import com.example.msaccount_se181765.shared.utils.DateUtils;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponse> handleAuth(AuthException ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.UNAUTHORIZED.value())
                .errorCode("UNAUTHORIZED")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAccountExist(AccountAlreadyExistException ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode("ACCOUNT_ALREADY_EXIST")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .errorCode("ILLEGAL_ARGUMENT")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<ErrorResponse> handlePassNotMatch(PasswordNotMatchException ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode("ACCOUNT_PASSWORD_NOT_MATCH")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(Exception ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.FORBIDDEN.value())
                .errorCode("FORBIDDEN")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
    }

    @ExceptionHandler({NoSuchElementException.class, ResourceNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFound(Exception ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode("NOT_FOUND")
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }



    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorResponse> handleMaxSize(MaxUploadSizeExceededException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE.value()).body(
                ErrorResponse.builder()
                        .success(false)
                        .status(HttpStatus.PAYLOAD_TOO_LARGE.value())
                        .errorCode("PAYLOAD_TOO_LARGE")
                        .message("Uploaded file too large more than " + ex.getMaxUploadSize() + " bytes")
                        .path(request.getRequestURI())
                        .timestamp(DateUtils.now())
                        .build()
        );
    }


    @ExceptionHandler({MethodArgumentNotValidException.class, UnexpectedTypeException.class})
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        ErrorResponse body = ErrorResponse.builder()
                .success(false)
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode("VALIDATION_ERROR")
                .message(errors.toString())
                .errorCode("VALIDATION_ERROR")
                .path(request.getRequestURI())
                .timestamp(DateUtils.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
