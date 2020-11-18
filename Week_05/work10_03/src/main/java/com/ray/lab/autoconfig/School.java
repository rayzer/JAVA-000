package com.ray.lab.autoconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
public class School implements ISchool {

    String name;
    
    @Autowired(required = true)
    Klass class1;
    
    @Resource(name = "student100")
    Student student100;
    
    @Override
    public void ding(){
        System.out.println("School: "+ name +": Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
}
