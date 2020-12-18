package io.kimmking.rpcfx.demo.provider.config;

import io.kimmking.rpcfx.demo.api.OrderService;
import io.kimmking.rpcfx.demo.api.UserService;
import io.kimmking.rpcfx.demo.provider.impl.OrderServiceImpl;
import io.kimmking.rpcfx.demo.provider.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(name = "io.kimmking.rpcfx.demo.api.UserService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "io.kimmking.rpcfx.demo.api.OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
}
