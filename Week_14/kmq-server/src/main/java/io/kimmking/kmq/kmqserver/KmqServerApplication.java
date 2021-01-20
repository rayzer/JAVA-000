package io.kimmking.kmq.kmqserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"io.kimmking.kmq.core"})
public class KmqServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KmqServerApplication.class, args);
    }

}
