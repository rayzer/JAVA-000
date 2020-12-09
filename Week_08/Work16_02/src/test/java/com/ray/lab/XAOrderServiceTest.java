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

import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XAOrderServiceTest.class)
@Import(TransactionConfiguration.class)
@ComponentScan(basePackages = "homework")
@ActiveProfiles("sharding-databases-tables")
public class XAOrderServiceTest {
    
    @Autowired
    private XAOrderService orderService;
    
    @Before
    public void setUp() {
        orderService.init();
    }
    
    @After
    public void cleanUp() {
        orderService.cleanup();
    }

    @Test
    public void assertInsertFailed() {
        try {
            orderService.insertFailed(10);
        } catch (final Exception ignore) {
        }
        assertThat(orderService.selectAll(), is(0));
    }

    @Test
    public void assertInsertSuccess() {
        assertThat(orderService.insert(20), is(TransactionType.XA));
        assertThat(orderService.selectAll(), is(20));
    }
}
