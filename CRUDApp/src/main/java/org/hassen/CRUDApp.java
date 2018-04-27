package org.hassen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CRUDApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(CRUDApp.class, args);
    }
}
