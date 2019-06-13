package com.practice.xxljob.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class XxljobDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxljobDemoApplication.class, args);
    }

}
