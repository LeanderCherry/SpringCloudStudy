package com.leander.micro.configserver.controller;

import com.leander.micro.configserver.service.ConfigClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Leander
 * @date 2018/6/10 0:36
 * @since [version]
 **/
@RestController
public class ConfigClientController
{
    @Autowired
    private ConfigClientService service;

    @GetMapping(value = "/hello",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello()
    {
        return service.sayHello();
    }
}
