package com.eureka.twineureka1072;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class TwinEureka2072Application {

    public static void main(String[] args) {
        SpringApplication.run(TwinEureka2072Application.class, args);
    }

}
