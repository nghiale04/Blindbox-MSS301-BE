package com.example.msblindbox_se181765.config;

import com.example.msblindbox_se181765.entity.BlindBoxCategories;
import com.example.msblindbox_se181765.entity.BlindBoxes;
import com.example.msblindbox_se181765.repository.BlindBoxRepository;
import com.example.msblindbox_se181765.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepo;
    private final BlindBoxRepository boxRepo;

    @Override
    public void run(String... args) {
        if (categoryRepo.count() == 0) {
            // Seed Categories
            BlindBoxCategories fantasy = BlindBoxCategories.builder()
                    .categoryName("Fantasy")
                    .description("Mystical creatures, wizards, and legendary beings.")
                    .rarityLevel("Common to Ultra Rare")
                    .priceRange("$10 - $60")
                    .build();

            BlindBoxCategories gaming = BlindBoxCategories.builder()
                    .categoryName("Gaming")
                    .description("Blind boxes featuring characters from popular video games.")
                    .rarityLevel("Common to Epic")
                    .priceRange("$25 - $70")
                    .build();

            BlindBoxCategories scifi = BlindBoxCategories.builder()
                    .categoryName("Sci-Fi")
                    .description("Space, futuristic themes, and robotic collectibles.")
                    .rarityLevel("Rare to Legendary")
                    .priceRange("$30 - $80")
                    .build();

            BlindBoxCategories anime = BlindBoxCategories.builder()
                    .categoryName("Anime")
                    .description("Popular anime characters and themed mystery figures.")
                    .rarityLevel("Common to Legendary")
                    .priceRange("$15 - $100")
                    .build();

            BlindBoxCategories steampunk = BlindBoxCategories.builder()
                    .categoryName("Steampunk")
                    .description("Victorian-era inspired mechanical and fantasy figures.")
                    .rarityLevel("Rare to Epic")
                    .priceRange("$100 - $190")
                    .build();

            categoryRepo.saveAll(List.of(fantasy, gaming, scifi, anime, steampunk));

            // Seed BlindBoxes (BrandId chỉ giữ như field để map bên ms-brand)
            boxRepo.saveAll(List.of(
                    BlindBoxes.builder().name("Mystic Creatures Series 1")
                            .category(fantasy).rarity("Rare").price(29.99)
                            .releaseDate(LocalDate.of(2024, 1, 15)).stock(150).build(),
                    BlindBoxes.builder().name("Cyberpunk Warriors")
                            .category(gaming).rarity("Ultra Rare").price(49.99)
                            .releaseDate(LocalDate.of(2023, 11, 20)).stock(75).build(),
                    BlindBoxes.builder().name("Fantasy Legends")
                            .category(fantasy).rarity("Common").price(19.99)
                            .releaseDate(LocalDate.of(2024, 2, 10)).stock(200).build(),
                    BlindBoxes.builder().name("Space Explorers")
                            .category(scifi).rarity("Epic").price(59.99)
                            .releaseDate(LocalDate.of(2023, 12, 5)).stock(50).build(),
                    BlindBoxes.builder().name("Neon Anime Stars")
                            .category(anime).rarity("Legendary").price(99.99)
                            .releaseDate(LocalDate.of(2024, 3, 1)).stock(25).build(),
                    BlindBoxes.builder().name("Retro Arcade Heroes")
                            .category(gaming).rarity("Common").price(24.99)
                            .releaseDate(LocalDate.of(2024, 1, 30)).stock(180).build(),
                    BlindBoxes.builder().name("Mythical Beasts Collection")
                            .category(fantasy).rarity("Ultra Rare").price(54.99)
                            .releaseDate(LocalDate.of(2023, 10, 10)).stock(60).build()
            ));
        }
    }
}
