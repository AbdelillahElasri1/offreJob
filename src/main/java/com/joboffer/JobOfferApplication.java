package com.joboffer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.joboffer.config")
public class JobOfferApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobOfferApplication.class, args);
    }

}
