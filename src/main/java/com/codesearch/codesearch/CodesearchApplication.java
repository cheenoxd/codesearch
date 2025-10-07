package com.codesearch.codesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codesearch"})
public class CodesearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodesearchApplication.class, args);
    }
}
