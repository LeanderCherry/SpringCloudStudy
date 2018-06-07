package com.leander.micro.feignbalance.itf;

import com.leander.micro.feignbalance.service.FallBackService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Leander
 * @date 2018/6/5 22:32
 * @since [version]
 **/
@FeignClient(value = "server-hello", fallback = FallBackServiceStatic.class)
public interface HelloServiceItf
{
    @GetMapping("/hi")
    String sayHello();
}

@Component
class FallBackServiceStatic implements HelloServiceItf
{

    @Override
    public String sayHello()
    {
        return "Sorry, there is an error.";
    }
}
