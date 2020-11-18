package com.ray.lab.beanInjection;

import java.util.StringJoiner;

class SimpleBeanViaXML {
    String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleBeanViaXML.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
