package com.example.msbrand_se181765.config;

import com.example.msbrand_se181765.entity.BlindBoxBrand;
import com.example.msbrand_se181765.entity.BlindBoxes;
import com.example.msbrand_se181765.repository.BlindBoxRepository;
import com.example.msbrand_se181765.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final BrandRepository brandRepo;
    private final BlindBoxRepository boxRepo;

    @Override
    public void run(String... args) {
        if (brandRepo.count() == 0) {
            // Seed Brands
            BlindBoxBrand popmart = BlindBoxBrand.builder()
                    .brandName("POP MART")
                    .countryOfOrigin("China")
                    .build();

            BlindBoxBrand funko = BlindBoxBrand.builder()
                    .brandName("Funko")
                    .countryOfOrigin("USA")
                    .build();

            BlindBoxBrand kidrobot = BlindBoxBrand.builder()
                    .brandName("Kidrobot")
                    .countryOfOrigin("USA")
                    .build();

            brandRepo.saveAll(List.of(popmart, funko, kidrobot));

            // Seed BlindBoxes referencing brands
            boxRepo.saveAll(List.of(
                    BlindBoxes.builder().name("Mystic Creatures Series 1")
                            .brand(popmart).rarity("Rare").price(29.99)
                            .releaseDate(LocalDate.of(2024, 1, 15)).stock(150).build(),
                    BlindBoxes.builder().name("Cyberpunk Warriors")
                            .brand(funko).rarity("Ultra Rare").price(49.99)
                            .releaseDate(LocalDate.of(2023, 11, 20)).stock(75).build(),
                    BlindBoxes.builder().name("Fantasy Legends")
                            .brand(popmart).rarity("Common").price(19.99)
                            .releaseDate(LocalDate.of(2024, 2, 10)).stock(200).build(),
                    BlindBoxes.builder().name("Space Explorers")
                            .brand(kidrobot).rarity("Epic").price(59.99)
                            .releaseDate(LocalDate.of(2023, 12, 5)).stock(50).build(),
                    BlindBoxes.builder().name("Neon Anime Stars")
                            .brand(popmart).rarity("Legendary").price(99.99)
                            .releaseDate(LocalDate.of(2024, 3, 1)).stock(25).build(),
                    BlindBoxes.builder().name("Retro Arcade Heroes")
                            .brand(funko).rarity("Common").price(24.99)
                            .releaseDate(LocalDate.of(2024, 1, 30)).stock(180).build(),
                    BlindBoxes.builder().name("Mythical Beasts Collection")
                            .brand(kidrobot).rarity("Ultra Rare").price(54.99)
                            .releaseDate(LocalDate.of(2023, 10, 10)).stock(60).build()
            ));
        }
    }
}
