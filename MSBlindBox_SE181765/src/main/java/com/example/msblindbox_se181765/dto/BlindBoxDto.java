package com.example.msblindbox_se181765.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class BlindBoxDto {
    private String categoryName;
    private String brandName;
    private Integer blindBoxId;

    private String name ;

    private String rarity;

    private Double price;
    private LocalDate releaseDate;

    private Integer stock;


}

