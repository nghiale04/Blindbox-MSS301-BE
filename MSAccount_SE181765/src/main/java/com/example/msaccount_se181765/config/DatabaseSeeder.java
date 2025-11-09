package com.example.msaccount_se181765.config;//package com.example.msaccount_se181765.config;

import com.example.msaccount_se181765.entity.SystemAccounts;
import com.example.msaccount_se181765.enums.RoleName;
import com.example.msaccount_se181765.repository.SystemAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {
    private final SystemAccountRepository storeAccountRepository;
    public void run(String... args) throws Exception {
        if (storeAccountRepository.count() == 0) {
            List<SystemAccounts> accounts = List.of(
                    SystemAccounts.builder()
                            .username("adminsys")
                            .email("admin@watches.com.vn")
                            .password("@1")
                            .role(RoleName.Administrator)
                            .isActive(true)
                            .build(),
                    SystemAccounts.builder()
                            .username("staff02")
                            .email("staff02@watches.com.vn")
                            .password("@1")
                            .role(RoleName.Moderator)
                            .isActive(true)
                            .build(),
                    SystemAccounts.builder()
                            .username("member01")
                            .email("member01@watches.com.vn")
                            .password("@1")
                            .role(RoleName.Member)
                            .isActive(true)
                            .build(),
                    SystemAccounts.builder()
                            .username("staff01")
                            .email("staff01@watches.com.vn")
                            .password("@1")
                            .role(RoleName.Developer)
                            .isActive(false)
                            .build()
            );
            storeAccountRepository.saveAll(accounts);
            System.out.println("✅ Seeded default StoreAccount data successfully!");
        } else {
            System.out.println("ℹ️ StoreAccount data already exists, skipping seeding.");
        }
    }
}