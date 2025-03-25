package com.example.golfclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.golfclub")
public class GolfClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(GolfClubApplication.class, args);
    }
}
