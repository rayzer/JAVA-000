package com.ray.lab.redisdemo;

public interface CountDown {
    void init(int count);
    Long countDown(int count) throws Exception;
}
