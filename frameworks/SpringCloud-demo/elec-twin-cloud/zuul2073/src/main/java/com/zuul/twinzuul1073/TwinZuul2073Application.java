package com.zuul.twinzuul1073;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TwinZuul2073Application {

    public static void main(String[] args) {
        SpringApplication.run(TwinZuul2073Application.class, args);
    }

}
