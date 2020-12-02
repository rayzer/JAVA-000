package com.ray.lab.ssjdbc;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.ray.lab.ssjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
public class SsJdbcApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SsJdbcApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        orderService.saveOrders();
        orderService.getOrders();
    }
}
