package com.pseudo.queue.internal.processing.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pseudo.queue")
public class InternalProcessingModule {
    public static void main(String[] args) {
        SpringApplication.run(InternalProcessingModule.class, args);
        System.out.println("Internal Processing module started");
    }
}
