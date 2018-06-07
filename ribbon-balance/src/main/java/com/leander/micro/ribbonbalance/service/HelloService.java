package com.leander.micro.ribbonbalance.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService
{
    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService()
    {
        return template.getForObject("http://server-hello/hi", String.class);
    }

    public String helloError()
    {
        return "Sorry, there is an error.";
    }
}
