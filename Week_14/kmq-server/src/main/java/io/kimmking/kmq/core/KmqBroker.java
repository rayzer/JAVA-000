package io.kimmking.kmq.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/kmq")
public final class KmqBroker {

    private static final Logger logger = LoggerFactory.getLogger(KmqBroker.class);

    public static final int CAPACITY = 10000;

    private final Map<String, Kmq> kmqMap = new ConcurrentHashMap<>(64);

    @PostMapping( "/topics")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTopic(@RequestParam String name){
        kmqMap.putIfAbsent(name, new Kmq(name, CAPACITY));
        logger.info(String.format("Topic %s created", name ));
    }

    @GetMapping("/topics")
    public HttpEntity<?> findKmq(@RequestParam String name) {
        logger.info(name);
        if(kmqMap.containsKey(name)) {
            logger.info(String.format("Topic %s exists, contains %d messages", name, kmqMap.get(name).size()));
            return ResponseEntity.status(HttpStatus.FOUND).body(String.format("Topic %s exists, contains %d messages", name, kmqMap.get(name).size()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping( "/messages")
    @ResponseStatus(HttpStatus.OK)
    public void sendMessage(@RequestParam String topic, @RequestBody KmqMessage msg){
        kmqMap.get(topic).send(msg);
        logger.info(String.format("Message sent to topic %s", topic ));
    }

    @GetMapping( "/messages")
    public HttpEntity<?> pollMessage(@RequestParam String topic){
        Kmq queue = kmqMap.get(topic);
        if (queue == null ){
            return ResponseEntity.notFound().build();
        } else {
            queue.send(new KmqMessage(null, "testestets"));
            return ResponseEntity.ok().body(kmqMap.get(topic).poll());
        }
    }

//    public KmqProducer createProducer() {
//        KmqProducer producer =  new KmqProducer(this);
//        return
//    }

//    public KmqConsumer createConsumer() {
//        return new KmqConsumer(this);
//    }

}
