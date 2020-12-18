package io.kimmking.rpcfx.demo.provider.impl;

import io.kimmking.rpcfx.demo.api.Order;
import io.kimmking.rpcfx.demo.api.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findOrderById(int id) {
        return new Order(1, "RPC", 1);
    }

}
