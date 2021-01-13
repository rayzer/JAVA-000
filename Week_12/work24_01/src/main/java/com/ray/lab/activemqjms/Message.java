package com.ray.lab.activemqjms;

import java.io.Serializable;
import java.util.StringJoiner;

public class Message implements Serializable {

    private String msg;
    private String name;

    public Message() {
    }

    public Message(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
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
}
