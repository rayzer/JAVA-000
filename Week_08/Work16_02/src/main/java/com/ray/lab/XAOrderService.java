/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ray.lab;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class XAOrderService {
    
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(XAOrderService.class);

    @Autowired
    public XAOrderService(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    void init() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS t_order");
        jdbcTemplate.execute("CREATE TABLE t_order (order_id BIGINT AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))");
    }

    void cleanup() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS t_order");
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public TransactionType insert(final int count) {
        return jdbcTemplate.execute("INSERT INTO t_order (user_id, status) VALUES (?, ?)", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            doInsert(count, preparedStatement);
            return TransactionTypeHolder.get();
        });
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void insertFailed(final int count) {
        jdbcTemplate.execute("INSERT INTO t_order (user_id, status) VALUES (?, ?)", (PreparedStatementCallback<TransactionType>) preparedStatement -> {
            doInsert(count, preparedStatement);
            throw new SQLException("mock transaction failed");
        });
    }
    
    private void doInsert(final int count, final PreparedStatement preparedStatement) throws SQLException {
        for (int i = 0; i < count; i++) {
            preparedStatement.setObject(1, i);
            preparedStatement.setObject(2, "init");
            preparedStatement.executeUpdate();
            logger.info("doInsert :"+i);
        }
    }

    int selectAll() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) AS count FROM t_order", Integer.class);
    }
}
