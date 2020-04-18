package com.example.demo;

import com.example.demo.persistence.Customer;
import com.example.demo.persistence.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class CustomerApplication {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public void createCustomers() {

        Faker faker = new Faker();

        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer(faker.name().firstName(), faker.name().lastName());
            customerRepository.save(customer);
        }
    }

}
