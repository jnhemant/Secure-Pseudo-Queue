package com.pseudo.queue.external.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pseudo.queue")
public class ExternalModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExternalModuleApplication.class, args);
        System.out.println("External Module app started");
    }
}
