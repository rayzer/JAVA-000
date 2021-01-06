package com.ray.lab.redisdemo;

import java.util.concurrent.TimeUnit;

public interface Lock {
    Boolean tryLock(String key, String value, long timeout, TimeUnit unit);
}
