package com.ray.lab.activemqjms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(javax.jms.Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Message msg = (Message)objectMessage.getObject();
            log.info("Received Message: "+ msg);
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }
    }
}