package com.mono40;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@RestController
public class CryptoQRMain extends SpringBootServletInitializer {

        @GetMapping("/version")
        public ResponseEntity version() {
            return ResponseEntity.ok("CryptoQR-services 1.0.0 version");
        }


        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(CryptoQRMain.class);
        }


        public static void main(String... args) {
            SpringApplication.run(CryptoQRMain.class, args);
        }
    }
