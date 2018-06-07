package com.leander.micro.feignbalance.itf;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Leander
 * @date 2018/6/7 1:16
 * @since [version]
 **/
@FeignClient(value = "server-hello", fallbackFactory = HelloServiceFallBackFactory.class)
public interface HelloServiceWithFallBackFactory
{
    @GetMapping("/hi")
    String sayHello();
}

@Component
class HelloServiceFallBackFactory implements FallbackFactory<HelloServiceWithFallBackFactory>
{

    @Override
    public HelloServiceWithFallBackFactory create(Throwable throwable)
    {
        return () -> "Sorry, there is an error, cause is " + throwable.getMessage();
    }
}
