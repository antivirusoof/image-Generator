package com.zeta.random.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@SpringBootApplication
@EnableRetry
public class ImageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageApplication.class, args);
    }


}
