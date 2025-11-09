package com.example.msaccount_se181765.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Username cannot be blank")
    @Email
    private String gmail;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 72, message = "Password must be 8–72 characters")
    private String password;
}

