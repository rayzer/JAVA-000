package com.ray.lab.redisdemo;

public class CountDownException extends Exception{

    final Long errorValue;

    public CountDownException(String s, Long error) {
        super(s);
        errorValue = error;
    }

    public Long getErrorValue() {
        return this.errorValue;
    }
}
