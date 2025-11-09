package com.example.msaccount_se181765.shared.utils;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class DateUtils {
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
