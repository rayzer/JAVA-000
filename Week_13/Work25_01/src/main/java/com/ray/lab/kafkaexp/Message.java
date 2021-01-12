package com.ray.lab.kafkaexp;

import java.util.StringJoiner;

public class Message {

    private String msg;
    private String name;

    public Message(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Message.class.getSimpleName() + "[", "]")
                .add("msg='" + msg + "'")
                .add("name='" + name + "'")
                .toString();
    }

    public Message() {
    }
}
