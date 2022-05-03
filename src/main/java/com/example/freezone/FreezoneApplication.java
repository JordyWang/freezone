package com.example.freezone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.example.freezone.mapper")
public class FreezoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreezoneApplication.class, args);
    }

}
