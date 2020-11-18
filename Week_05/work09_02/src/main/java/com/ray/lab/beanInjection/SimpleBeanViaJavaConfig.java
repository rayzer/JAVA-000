package com.ray.lab.beanInjection;

import java.util.StringJoiner;

class SimpleBeanViaJavaConfig {
    String name;

    public SimpleBeanViaJavaConfig() {
        this.name = "SimpleBean via JavaConfig";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleBeanViaJavaConfig.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
