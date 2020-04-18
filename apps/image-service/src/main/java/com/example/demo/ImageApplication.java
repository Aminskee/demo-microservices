package com.example.demo;

import com.example.demo.persistence.Image;
import com.example.demo.persistence.ImageRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageApplication {

    @Autowired
    ImageRepository imageRepository;

    public static void main(String[] args) {
        SpringApplication.run(ImageApplication.class, args);
    }

    @Bean
    public void createCustomers() {

        Faker faker = new Faker();

        for (int i = 0; i < 3; i++) {
            Image image = new Image(faker.name().nameWithMiddle());
            imageRepository.save(image);
        }

    }

}
