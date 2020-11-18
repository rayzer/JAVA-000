package com.ray.lab.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(SchoolProperties.class)
public class SchoolAutoConfiguration {
    @Autowired
    private SchoolProperties schoolProperties;

    @Autowired
    @Qualifier("student100")
    Student student100;

    @Autowired
    @Qualifier("student123")
    Student student123;

    @Bean(name="student100")
    public Student newStudent100(){
        Student s =  new Student();
        s.setId(100);
        s.setName("KK100");
        return s;
    }

    @Bean(name="student123")
    public Student newStudent123(){
        Student s =  new Student();
        s.setId(123);
        s.setName("KK123");
        return s;
    }

    @Bean
    @ConditionalOnMissingBean(Klass.class)
    public Klass klass(){
        Klass k = new Klass();
        k.setStudents(Arrays.asList(student100, student123));
        return k;
    }

    @Bean
    @ConditionalOnMissingBean(School.class)
    public School school(){
        School school = new School();
        school.setName(schoolProperties.getName());
        return school;
    }
}
