package com.ray.lab.dynamicds;

import com.ray.lab.dynamicds.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicDSApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDSApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        orderService.getOrders();
        orderService.saveOrder();
    }
}
