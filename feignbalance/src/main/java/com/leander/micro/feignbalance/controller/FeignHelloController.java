package com.leander.micro.feignbalance.controller;

import com.leander.micro.feignbalance.itf.HelloServiceItf;
import com.leander.micro.feignbalance.itf.HelloServiceWithFallBackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leander
 * @date 2018/6/5 22:32
 * @since [version]
 **/
@RestController
public class FeignHelloController
{
    @Autowired
    HelloServiceItf service;

    @Autowired
    HelloServiceWithFallBackFactory serviceWithFallBackFactory;
    @GetMapping("/hello")
    public String sayHello()
    {
        return service.sayHello();
    }

    @GetMapping("/hello/v2")
    public String sayHello2()
    {
        return serviceWithFallBackFactory.sayHello();
    }
}
