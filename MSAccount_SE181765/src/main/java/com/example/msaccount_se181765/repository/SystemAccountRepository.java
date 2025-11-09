package com.example.msaccount_se181765.repository;

import com.example.msaccount_se181765.entity.SystemAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemAccountRepository extends JpaRepository<SystemAccounts, Integer> {
    Optional<SystemAccounts> findByEmail(String gmail);
}
