package com.ray.lab.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisCountDownService implements CountDown {
    public static final String Key = "ray-CountDown";
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void init(int count) {
        redisTemplate.delete(Key);
        redisTemplate.opsForValue().set(Key, Integer.valueOf(count));
    }

    @Override
    public Long countDown(int count) throws Exception {
        Long left = redisTemplate.opsForValue().decrement(Key);
        if (left > 0) {
            return left;
        } else {
            throw new Exception("Exceed limit! " + left );
        }
    }
}
