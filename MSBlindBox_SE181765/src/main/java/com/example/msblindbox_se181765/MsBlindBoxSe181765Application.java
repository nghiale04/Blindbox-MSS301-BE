package com.example.msblindbox_se181765;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.example.msblindbox_se181765.feign")
@SpringBootApplication
public class MsBlindBoxSe181765Application {

    public static void main(String[] args) {
        SpringApplication.run(MsBlindBoxSe181765Application.class, args);
    }

}
