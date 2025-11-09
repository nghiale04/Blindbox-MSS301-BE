package com.example.msaccount_se181765.entity;

import com.example.msaccount_se181765.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "system_account")
public class SystemAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private String username;
    private String password;
    private String email;
    private RoleName role;
    private Boolean isActive;

}
