package com.ray.lab;

import java.util.StringJoiner;

public class SimpleObject {
    private Long id;
    private String name;
    private String message;

    public SimpleObject(Long id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public SimpleObject(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleObject.class.getSimpleName() + "[", "] ")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("message='" + message + "'")
                .toString();
    }
}
