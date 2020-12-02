package com.ray.lab.ssjdbc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private DataSource dataSource;

    public void getOrders() throws SQLException {
        String sql = "SELECT  *  FROM eshop.order where 1=1";
        final Connection connection = dataSource.getConnection();
        final PreparedStatement ps = connection.prepareStatement(sql);
        final ResultSet resultSet = ps.executeQuery();
        int count = 0;
        while (resultSet.next()) {
            count++;
        }
        log.info(count + " row fetched");
    }

    public void saveOrders() throws SQLException {
        final Connection connection = dataSource.getConnection();

        String SQL = "INSERT INTO eshop.order(" +
                "order_sn, " +
                "customer_id, " +
                "address, " +
                "seller_id, " +
                "payment_method, " +
                "order_money," +
                "order_status, create_time, modified_time)" +
                "VALUES (?, ?, ?, ?, ?, ?, DEFAULT, now(), now())";
        PreparedStatement ps = connection.prepareStatement(SQL);

        for (int i = 0; i < 100; i++) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setInt(2, i);
            ps.setString(3, "地址"+i);
            ps.setInt(4, i);
            ps.setInt(5, 0);
            ps.setBigDecimal(6, new BigDecimal(i));
            ps.addBatch();
        }
        ps.executeBatch();

        ps.close();
        connection.close();
        log.info("100 row inserted");
    }
}
