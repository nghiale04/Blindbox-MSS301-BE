package com.example.msaccount_se181765.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Integer accountId;
    private String gmail;
    private LocalDateTime createdAt;
    private String fullName;
    private String phoneNumber;
    private String sex;
    private String address;
    private String avatarUrl;
    private Date dateOfBirth;
    private boolean isEnabled;
    private String roleName;
}
