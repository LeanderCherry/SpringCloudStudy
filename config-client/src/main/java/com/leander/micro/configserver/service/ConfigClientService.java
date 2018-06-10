package com.leander.micro.configserver.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @author Leander
 * @date 2018/6/10 0:34
 * @since [version]
 **/
@Service
@RefreshScope
public class ConfigClientService
{
    @Value("${name}")
    private String name;

    @Value("${server.port}")
    private String port;

    public String sayHello()
    {
        return "Hello, I'm " + name + ":" + port + ", nice to meet you.";
    }
}
