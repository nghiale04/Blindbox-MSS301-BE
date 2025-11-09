package com.example.msblindbox_se181765.repository;

import com.example.msblindbox_se181765.entity.BlindBoxCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<BlindBoxCategories, Integer> {
}
