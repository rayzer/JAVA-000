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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(TransactionConfiguration.class)
public class ExampleMainApplication {
    
    @Autowired
    private XAOrderService orderService;
    
    public static void main(final String[] args) {
        SpringApplication.run(ExampleMainApplication.class, args);
    }
    
    @PostConstruct
    public void executeOrderService() {
        orderService.init();
        orderService.selectAll();
        orderService.insert(10);
        orderService.selectAll();
        //orderService.cleanup();
    }
}
