package com.leander.micro.feignbalance.service;

import com.leander.micro.feignbalance.itf.HelloServiceItf;
import org.springframework.stereotype.Component;

/**
 * @author Leander
 * @date 2018/6/5 22:32
 * @since [version]
 **/
public class FallBackService implements HelloServiceItf
{
    @Override
    public String sayHello()
    {
        return "Sorry";
    }
}
