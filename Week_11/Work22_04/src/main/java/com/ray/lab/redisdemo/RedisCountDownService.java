package com.ray.lab.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCountDownService implements CountDown {
    public static final String KEY = "ray-CountDown";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void init(int count) {
        this.redisTemplate.delete(KEY);
        this.redisTemplate.opsForValue().set(KEY, count);
    }

    @Override
    public Long countDown(int count) throws CountDownException {
        Long left = this.redisTemplate.opsForValue().decrement(KEY);
        if (left != null && left.longValue() >= 0) {
            return left;
        } else {
            throw new CountDownException("Exceed limit!", left);
        }
    }
}
