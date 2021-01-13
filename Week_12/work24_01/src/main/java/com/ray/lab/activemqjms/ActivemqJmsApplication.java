package com.ray.lab.activemqjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivemqJmsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqJmsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Message msg = new Message("Hi", "The ActiveMQ");
        sendMessage(msg);
    }

    @Autowired
    JmsProducer jmsProducer;

    public void sendMessage( Message message){
        jmsProducer.sendMessage(message);
    }

}
