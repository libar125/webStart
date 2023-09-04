package com.qing.fapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.qing")
public class WebfapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebfapiApplication.class);
    }
}
