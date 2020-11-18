package com.ray.lab.starterdemo;

import com.ray.lab.autoconfig.Klass;
import com.ray.lab.autoconfig.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StarterdemoApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(StarterdemoApplication.class, args);
	}

	@Autowired
	private School school;

	@Autowired
	private ApplicationContext context;

	@Override
	public void run(String... args) {
		school.ding();
		school.getClass1().dong();
		System.out.println(String.join(",", context.getBeanDefinitionNames()));
	}
}
