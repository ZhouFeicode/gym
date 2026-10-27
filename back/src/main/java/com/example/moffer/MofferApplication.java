package com.example.moffer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.moffer.mapper")
public class MofferApplication {
    public static void main(String[] args) {
        SpringApplication.run(MofferApplication.class, args);
    }

}
