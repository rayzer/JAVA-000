package com.ray.lab.kafkaexp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
public class KafkaExpApplication implements CommandLineRunner {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KafkaExpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Thread.sleep(2000);
        sendMessage(new Message("Hi", "Ray"));
        sendMessage(new Message("Hi", "filtered one"));
    }

    public void sendMessage(Message message) {
        ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send("ray-lab", message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
            @Override
            public void onSuccess(SendResult<String, Message> result) {
                System.out.println("Sent message=[" + message.getName() + ", " + message.getMsg() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message.getName() + ", " + message.getMsg() + "] due to : " + ex.getMessage());
            }
        });
    }

    @KafkaListener(topics = "ray-lab", groupId = "group1", containerFactory = "kafkaListenerContainerFactory")
    public void listenGroup1(Message message) {
        System.out.println("listenGroup1: Received message in group group1: " + message.toString());
    }

    @KafkaListener(topics = "ray-lab", groupId = "group2", containerFactory = "filteredKafkaListenerContainerFactory")
    public void listenGroup1FilteredMessage(Message message) {
        System.out.println("listenGroup1FilteredMessage: Received not filtered message in group group2: " + message.toString());
    }
}
