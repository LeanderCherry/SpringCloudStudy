package com.leander.micro.serverhello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServerHelloApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(ServerHelloApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home()
    {
        return "Hello world";
    }

    @GetMapping("/test/info")
    public String info()
    {
        return "I'm here.";
    }

    @GetMapping("health")
    public String healthCheck()
    {
        return "I'm healthy.";
    }
}
