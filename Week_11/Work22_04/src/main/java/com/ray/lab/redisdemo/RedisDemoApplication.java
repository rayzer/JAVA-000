package com.ray.lab.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class RedisDemoApplication implements CommandLineRunner {

    @Autowired
    RedisLockService lockService;

    @Autowired
    RedisCountDownService countDownService;

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        distributeLock();
        Thread.sleep(1000);
        System.out.println("\n");
        countDown();
    }

    public void distributeLock() {
        System.out.println("Redis based locking...");
        ExecutorService controllerThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            controllerThreadPool.execute(() -> {
                Boolean result = lockService.tryLock("ray",  "001", 20, TimeUnit.SECONDS);
                String threadName = Thread.currentThread().getName();
                if (result) {
                    System.out.println(threadName+" has got the lock");
                } else {
                    System.out.println(threadName+" failed to lock");
                }
            });
        }
        controllerThreadPool.shutdown();
    }

    public void countDown() {
        System.out.println("Redis based count down....");
        countDownService.init(8);
        ExecutorService controllerThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            controllerThreadPool.execute(() -> {
                Long left;
                String threadName = Thread.currentThread().getName();
                try {
                    left = countDownService.countDown(1);
                    System.out.println(threadName +" count down to " + left);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(threadName +" failed to count down. ");
                }
            });
        }
        controllerThreadPool.shutdown();
    }
}
