package com.ray.lab.beanInjection;

import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
class SimpleBeanViaAnnotation {
    String name;

    public SimpleBeanViaAnnotation() {
        this.name = "SimpleBean via Annotation @Component";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SimpleBeanViaAnnotation.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
