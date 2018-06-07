package com.leander.micro.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class ConfigClientApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${name}")
    String name;
    @GetMapping(value = "/hello")
    public String hello()
    {
        return "I'm " + name + ".";
    }
}
