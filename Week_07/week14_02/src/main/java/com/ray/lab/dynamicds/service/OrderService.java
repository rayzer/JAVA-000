package com.ray.lab.dynamicds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    @Qualifier("MasterJdbcTemplate")
    private JdbcTemplate masterJdbcTemplate;

    @Autowired
    @Qualifier("SlaveJdbcTemplate")
    private JdbcTemplate slaveJdbcTemplate;

    public void getOrders(){
        String sql = "SELECT * FROM eshop.order";
        List<Map<String, Object>> result =  slaveJdbcTemplate.queryForList(sql);
        System.out.println(result.size() + " row fetched");
    }

    public void saveOrder(){
        String SQL = "INSERT INTO eshop.order(order_sn, customer_id, address, seller_id, payment_method, " +
                "order_money, order_status, create_time, modified_time) VALUES (?, ?, ?, ?, ?, ?, DEFAULT, now(), now())";

        Object[]params = new Object[] {
                UUID.randomUUID().toString(),
                99,
                "地址地址地址",
                99,
                0,
                new BigDecimal(0)
        };
        int count =  masterJdbcTemplate.update(SQL, params);
        System.out.println(count + " row inserted");
    }
}
