package com.ray.lab;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LoadDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root","");
        connection.setAutoCommit(false);
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
        for (int i = 0; i < 1000000; i++) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setInt(2, i);
            ps.setString(3, "地址"+i);
            ps.setInt(4, i);
            ps.setInt(5, 0);
            ps.setBigDecimal(6, new BigDecimal(i));
            ps.addBatch();
        }

        System.out.println("开始导入");
        long startTime = System.nanoTime();

        ps.executeBatch();
        connection.commit();

        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("导入百万条订单数据耗时:" + millis + "毫秒");

        ps.close();
        connection.close();
    }
}
