package com.ray.lab.beanInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInjection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //via XML
        SimpleBeanViaXML simpleBeanViaXML = context.getBean(SimpleBeanViaXML.class);
        System.out.println(simpleBeanViaXML);

        //Via Annotation
        SimpleBeanViaAnnotation simpleBeanViaAnnotation = context.getBean(SimpleBeanViaAnnotation.class);
        System.out.println(simpleBeanViaAnnotation);

        //Via Configuration
        SimpleBeanViaJavaConfig simpleBeanViaJavaConfig = context.getBean(SimpleBeanViaJavaConfig.class);
        System.out.println(simpleBeanViaJavaConfig);
    }
}
