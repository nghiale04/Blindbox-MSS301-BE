package com.example.msbrand_se181765.repository;

import com.example.msbrand_se181765.entity.BlindBoxes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlindBoxRepository extends JpaRepository<BlindBoxes, Integer> {
    void deleteByBlindBoxId(Integer blindBoxId);
}
